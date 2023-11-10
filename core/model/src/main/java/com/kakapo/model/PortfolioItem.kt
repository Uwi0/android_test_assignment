package com.kakapo.model

data class PortfolioItem(
    val label: String = "",
    val percentage: String  = ""
)

data class PortfolioDetailItem(
    val trxDate: String = "",
    val nominal: Int = 0,
)
