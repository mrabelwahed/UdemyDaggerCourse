package com.pokemon.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pokemon.BaseApp
import com.pokemon.POKEMON_DETAILS_KEY
import com.pokemon.R
import com.pokemon.data.PokemonResponse
import com.pokemon.ui.viewstate.ServerDataState
import com.pokemon.viewmodel.PokeMonListViewModel
import com.pokemon.viewmodel.ViewModelFactory
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.processors.PublishProcessor
import kotlinx.android.synthetic.main.fragment_pokemon_list.*
import javax.inject.Inject


class PokemonListFragment : BaseFragment(), OnClickListener {
    private val pokemonDetailsFragment = PokemonDetailsFragment()
    private lateinit var pokeMonListViewModel: PokeMonListViewModel
    @Inject
    lateinit var pokemonListAdapter: PokemonListAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    val paginator = PublishProcessor.create<Int>()

    private var totalItemCount = 0
    private var lastVisibleItem = 0
    private var loading = false
    private lateinit var linearLayoutManager: LinearLayoutManager
    private val VISIBLE_THRESHOLD = 1
    //private var loadMore = true
    private var offest = 0

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        (activity?.applicationContext as BaseApp).appComponent
            .newPokemonLisComponent().inject(this)
        pokeMonListViewModel =
            ViewModelProviders.of(this, viewModelFactory)[PokeMonListViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun setupView() {
        linearLayoutManager = LinearLayoutManager(context)
        pokemonListAdapter.setClickListener(this)
        pokemonList.apply {
            layoutManager = linearLayoutManager
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = pokemonListAdapter
        }

    }

    private fun getPokemonListData() {
        pokeMonListViewModel.getPokemonList()
        observePokemonList()
    }

    private fun setData(response: PokemonResponse?) {
        response?.results?.let { pokemonListAdapter.addPokmons(it) }
    }


    override fun onClick(position: Int, view: View) {

        getPokemonDetails(position + 1)
    }

    private fun observePokemonList() {
        pokeMonListViewModel.getLivePokemonList().observe(this, Observer {
            when (it) {
                is ServerDataState.success<*> -> setData(it.item as PokemonResponse?)
                is ServerDataState.error -> setError(it.message)
            }

        })
    }

    private fun setError(message: String?) {
        Log.e("ERROR", message)
    }


    override fun getLayoutById(): Int {
        return R.layout.fragment_pokemon_list
    }

    private fun initUI() {
        setupView()
        initPagination()
        setupLoadMoreListener()
        //getPokemonListData()
    }

    private fun setupLoadMoreListener() {
        pokemonList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                totalItemCount = linearLayoutManager.itemCount
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition()
                if (!loading && totalItemCount <= lastVisibleItem + VISIBLE_THRESHOLD) {
                    offest += 20
                   // if (loadMore)
                    paginator.onNext(offest)
                    loading = true
                }
            }
        })

    }

    private fun initPagination(){
        val disposable = paginator
            .doOnNext { offest ->
                loading = true
                pokemonListAdapter.addLoadingData()

            }
            .concatMap { offest -> dataFromNetwork(offest) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{response->
                loading = false
                pokemonListAdapter.removeLoadingData()
                response?.results?.let { pokemonListAdapter.addPokmons(it) }

            }

        paginator.onNext(offest)
    }

    private fun dataFromNetwork(offest: Int): Flowable<PokemonResponse> {
        return pokeMonListViewModel.getItems(offest)
    }


    private fun getPokemonDetails(id: Int) {
        val bundle = Bundle()
        bundle.putInt(POKEMON_DETAILS_KEY, id)
        pokemonDetailsFragment.arguments = bundle

        (activity as BaseActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.container, pokemonDetailsFragment)
            .addToBackStack(null)
            .commit()

    }
}
