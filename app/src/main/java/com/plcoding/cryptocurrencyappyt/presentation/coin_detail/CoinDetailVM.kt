package com.plcoding.cryptocurrencyappyt.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofit.data.Resource
import com.plcoding.cryptocurrencyappyt.common.cons
import com.plcoding.cryptocurrencyappyt.domain.usecase.getcoin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@HiltViewModel
class CoinDetailVM @Inject constructor(
    public val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel(){

    private val _state = mutableStateOf(CoinDetailState())
    val state : State<CoinDetailState> = _state



    init {
        savedStateHandle.get<String>(cons.PARAM_COINID)?.let { coindId ->
            getCoin(coindId)
        }
    }

    private fun getCoin(coinId : String){

        getCoinUseCase(coinId).onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = CoinDetailState(coin = result.data)
                }
                is Resource.Error -> {
                    _state.value = CoinDetailState(
                        error = result.message ?: "AN ERROR OCCURCED"
                    )
                }
                is Resource.loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)

    }
}