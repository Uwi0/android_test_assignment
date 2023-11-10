package com.kakapo.data.model

import com.kakapo.common.type.orZero
import com.kakapo.model.PortfolioDetailItem
import com.kakapo.model.PortfolioItem
import com.kakapo.network.model.response.PortfolioResponse

fun toPortfolioItem(entity: PortfolioResponse.Data) = PortfolioItem(
    label = entity.label.orEmpty(),
    percentage = entity.percentage.orEmpty()
)

fun toPortfolioDetailItem(entity: PortfolioResponse.Data.Data) = PortfolioDetailItem(
    trxDate = entity.trxDate.orEmpty(),
    nominal = entity.nominal.orZero()
)