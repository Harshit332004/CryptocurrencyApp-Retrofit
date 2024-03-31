package com.plcoding.cryptocurrencyappyt.domain.repository

import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDetaildto
import com.plcoding.cryptocurrencyappyt.data.remote.dto.Coindto

interface CoinRepository {

    suspend fun getCoins(): List<Coindto>

    suspend fun getCoinById(coinId : String ) : CoinDetaildto
}