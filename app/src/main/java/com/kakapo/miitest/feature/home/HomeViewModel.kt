package com.kakapo.miitest.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kakapo.common.type.asResult
import com.kakapo.common.type.subscribe
import com.kakapo.domains.scan_code.ScanCodeUseCase
import com.kakapo.logger.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val scanCodeUseCase: ScanCodeUseCase
): ViewModel() {

    val uiState get() = _uiState.asStateFlow()
    private val _uiState = MutableStateFlow(HomeUiState())

    val uiSideEffect get() = _uiSideEffect.asSharedFlow()
    private val _uiSideEffect = MutableSharedFlow<HomeSideEffect>()

    fun scanQrCode() = viewModelScope.launch {
        _uiState.update { it.copy(isDialogVisible = true) }

    }

    private fun handleError(throwable: Throwable?){
        emitSideEffect(ShowError(throwable?.message))
    }

    private fun emitSideEffect(effect: HomeSideEffect) = viewModelScope.launch {
        _uiSideEffect.emit(effect)
    }
}