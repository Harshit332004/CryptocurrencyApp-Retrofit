package com.plcoding.cryptocurrencyappyt.data.remote

import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDetaildto
import com.plcoding.cryptocurrencyappyt.data.remote.dto.Coindto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("v1/coins")
    suspend fun getCoins() : List<Coindto>


    @GET("v1/coins/{coinID}")
    suspend fun getCoinBId(@Path("coinID") coinID : String) : CoinDetaildto
}