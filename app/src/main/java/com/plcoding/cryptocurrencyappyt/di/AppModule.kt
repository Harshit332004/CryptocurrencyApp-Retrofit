package com.plcoding.cryptocurrencyappyt.di

import android.app.Application
import com.plcoding.cryptocurrencyappyt.common.cons
import com.plcoding.cryptocurrencyappyt.data.remote.CoinPaprikaApi
import com.plcoding.cryptocurrencyappyt.data.repositoty.CoinRepoImpl
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create

import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory as GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule  {

    @Provides
    @Singleton
    fun provideApi():CoinPaprikaApi{

        return Retrofit.Builder()
            .baseUrl(cons.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepo(api: CoinPaprikaApi) : CoinRepository{
        return CoinRepoImpl(api)
    }



}