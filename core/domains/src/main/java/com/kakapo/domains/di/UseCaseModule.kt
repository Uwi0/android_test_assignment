package com.kakapo.domains.di

import com.kakapo.domains.scan_code.ScanCodeUseCase
import com.kakapo.domains.scan_code.ScanCodeUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @Binds
    fun bindScanCodeUseCase(
        useCase: ScanCodeUseCaseImpl
    ): ScanCodeUseCase
}