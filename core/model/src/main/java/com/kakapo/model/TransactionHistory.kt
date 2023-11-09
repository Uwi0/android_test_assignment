package com.kakapo.model

data class TransactionHistory(
    val id: String = "",
    val amount: Int = 0,
    val accountName: String = "",
    val merchantName: String = "",
)
