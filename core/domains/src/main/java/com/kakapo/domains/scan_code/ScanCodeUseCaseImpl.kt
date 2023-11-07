package com.kakapo.domains.scan_code

import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.codescanner.GmsBarcodeScanner
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ScanCodeUseCaseImpl @Inject constructor(
    private val scanner: GmsBarcodeScanner
): ScanCodeUseCase {
    override fun starScanning(): Flow<String> {
        return callbackFlow {
            scanner.startScan()
                .addOnSuccessListener {
                    launch {
                        send(it.rawValue ?: throw Exception("Invalid QR code"))
                    }
                }.addOnFailureListener {
                    it.printStackTrace()
                }
            awaitClose {  }
        }
    }
}