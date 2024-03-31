package com.plcoding.cryptocurrencyappyt.domain.usecase.get_coins

import com.example.retrofit.data.Resource
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoin
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoins_usecase @Inject constructor(
    private val repository: CoinRepository
){
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.loading<List<Coin>>()) // Explicitly provide the type List<Coin>
            val coins: List<Coin> = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins)) // Provide the type List<Coin>
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(message = e.localizedMessage ?: "error")) // Provide the type List<Coin>
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>(message = e.localizedMessage ?: "IOException occurred")) // Provide the type List<Coin>
        }
    }
}
/*
echo "# Crypto-App-RETROFIT-HILT-" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/Harshit332004/Crypto-App-RETROFIT-HILT-.git
git push -u origin main
*/