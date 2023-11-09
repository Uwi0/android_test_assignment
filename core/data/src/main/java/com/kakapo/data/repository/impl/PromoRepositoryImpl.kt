package com.kakapo.data.repository.impl

import com.kakapo.data.repository.base.PromoRepository
import com.kakapo.data.util.proceedResult
import com.kakapo.network.datasource.base.PromoApiRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PromoRepositoryImpl @Inject constructor(
    private val promoApiRemoteDataSource: PromoApiRemoteDataSource
): PromoRepository {
    override fun requestPromo(): Flow<Unit> = flow {
        proceedResult { promoApiRemoteDataSource.requestMessage() }
        emit(Unit)
    }
}