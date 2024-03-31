package com.plcoding.cryptocurrencyappyt.data.repositoty

import com.plcoding.cryptocurrencyappyt.data.remote.CoinPaprikaApi
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDetaildto
import com.plcoding.cryptocurrencyappyt.data.remote.dto.Coindto
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepoImpl @Inject constructor(
    private val api:CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<Coindto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetaildto {
        return api.getCoinBId(coinId)
    }
}