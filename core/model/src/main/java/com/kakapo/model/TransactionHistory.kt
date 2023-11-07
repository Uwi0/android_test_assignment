package com.kakapo.model

data class TransactionHistory(
    val id: Int,
    val amount: String,
    val accountName: String,
    val merchantName: String,
)
