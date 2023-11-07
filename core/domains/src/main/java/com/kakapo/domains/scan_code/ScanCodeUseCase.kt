package com.kakapo.domains.scan_code

import kotlinx.coroutines.flow.Flow

interface ScanCodeUseCase {

    fun starScanning(): Flow<String>
}