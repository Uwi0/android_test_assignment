package com.kakapo.app2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kakapo.common.type.asResult
import com.kakapo.common.type.subscribe
import com.kakapo.data.repository.base.PromoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val promoRepository: PromoRepository
): ViewModel() {

    val uiSideEffect get() = _uiSideEffect.asSharedFlow()
    private val _uiSideEffect = MutableSharedFlow<MainSideEffect>()

    init {
        requestPromo()
    }

    private fun requestPromo() = viewModelScope.launch {
        promoRepository.requestPromo().asResult().subscribe(
            onError = ::handleError
        )
    }

    private fun handleError(throwable: Throwable?){
        emitSideEffect(ShowError(throwable?.message))
    }

    private fun emitSideEffect(effect: MainSideEffect) = viewModelScope.launch {
        _uiSideEffect.emit(effect)
    }

}

sealed interface MainSideEffect
data class ShowError(private val _message: String?): MainSideEffect{
    val message get() = _message ?: "Error"
}