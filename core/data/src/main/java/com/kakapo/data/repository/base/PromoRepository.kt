package com.kakapo.data.repository.base

import kotlinx.coroutines.flow.Flow

interface PromoRepository {

    fun requestPromo(): Flow<Unit>
}