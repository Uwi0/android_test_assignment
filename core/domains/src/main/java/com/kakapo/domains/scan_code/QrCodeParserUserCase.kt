package com.kakapo.domains.scan_code

import arrow.core.Either
import com.kakapo.model.TransactionHistory
import kotlin.Exception

fun parseQrBarcodeTransaction(code: String): Either<Exception, TransactionHistory> {
    return try {

        val rawCode = code.split(".")
        val accountName = rawCode[0]
        val idTransaction = rawCode[1]
        val merchantName = rawCode[2]
        val amount = rawCode[3].toInt()
        val transaction = TransactionHistory(
            id = idTransaction,
            amount = amount,
            accountName = accountName,
            merchantName = merchantName
        )
        Either.Right(transaction)
    }catch (e: Exception){
        Either.Left(e)
    }
}