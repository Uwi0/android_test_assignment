package com.kakapo.miitest.feature.home

import com.kakapo.model.TransactionHistory

data class HomeUiState(
    val initialBalance: Int = 10000,
    val transactionHistories: List<TransactionHistory> = emptyList(),
    val isDialogVisible: Boolean = false,
    val scannedCode: String = ""
){
    fun updateSuccessScanned(code: String) = copy(
        isDialogVisible = true,
        scannedCode = code
    )
}

sealed interface HomeSideEffect
data class ShowError(private val _message: String?): HomeSideEffect{
    val message get() = _message ?: "Error"
}