package com.plcoding.cryptocurrencyappyt.domain.usecase.getcoin

import com.example.retrofit.data.Resource

import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoinDetail

import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetail
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.loading<CoinDetail>()) // Explicitly provide the type CoinDetail
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin)) // Provide the type CoinDetail
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(message = e.localizedMessage ?: "error")) // Provide the type CoinDetail
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>(message = e.localizedMessage ?: "IOException occurred")) // Provide the type CoinDetail
        }
    }

}