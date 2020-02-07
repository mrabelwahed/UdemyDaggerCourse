package viewassertion

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import org.junit.Assert.assertEquals
import kotlin.properties.Delegates

class RecyclerViewItemCountAssertion : ViewAssertion {
 var  itemCount :Int =0
    override fun check(view: View?, noViewFoundException: NoMatchingViewException?) {
        if (noViewFoundException != null)
            throw noViewFoundException

        val adapterItemCount = (view as RecyclerView).adapter?.itemCount
        assertEquals(adapterItemCount, itemCount)
    }

    companion object{
       fun  hasItemCount(itemCount:Int) : ViewAssertion{
           val viewAssertion = RecyclerViewItemCountAssertion()
           viewAssertion.itemCount = itemCount
           return viewAssertion
       }
    }
}