package com.plcoding.cryptocurrencyappyt.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.data.Resource
import com.plcoding.cryptocurrencyappyt.domain.usecase.get_coins.GetCoins_usecase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


class CoinListVM @Inject constructor(
    private val getCoinsUseCase: GetCoins_usecase
):ViewModel(){

    private val _state = mutableStateOf(CoinListState())
    val state : State<CoinListState> = _state

init {
    getCoins()
}



    private fun getCoins(){

        getCoinsUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                _state.value = CoinListState(coins = result.data?: emptyList())
                }
                is Resource.Error -> {
                _state.value = CoinListState(
                    error = result.message ?: "AN ERROR OCCURCED"
                )
                }
                is Resource.loading -> {
                _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)

    }
}





