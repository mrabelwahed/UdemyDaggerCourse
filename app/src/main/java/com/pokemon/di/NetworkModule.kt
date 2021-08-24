package com.pokemon.di

import com.pokemon.BuildConfig
import com.pokemon.data.network.PokemonApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import com.pokemon.common.AppConst
@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesHttpLogging (): HttpLoggingInterceptor{
        val logging = HttpLoggingInterceptor()
        if(BuildConfig.DEBUG)
            logging.level =  HttpLoggingInterceptor.Level.BODY
        return logging
    }


    @Singleton
    @Provides
    fun providesOkhttpClient(loggingInterceptor: HttpLoggingInterceptor) :OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .readTimeout(AppConst.TIMEOUT_REQUEST, TimeUnit.SECONDS)
            .connectTimeout(AppConst.TIMEOUT_REQUEST, TimeUnit.SECONDS)
            .build()

    }

    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient:OkHttpClient) : Retrofit.Builder{
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    }

    @Singleton
    @Provides
    fun providesPokemonApi(retrofit : Retrofit.Builder) : PokemonApi{
        return retrofit.baseUrl(AppConst.BASE_URL).build().create(PokemonApi::class.java)
    }

}