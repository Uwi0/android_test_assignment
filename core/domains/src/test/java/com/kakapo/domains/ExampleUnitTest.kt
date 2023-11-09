package com.kakapo.domains

import com.kakapo.domains.scan_code.parseQrBarcodeTransaction
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun `test when qr code is correct return with account name in it`() {
        val code = "BNI.ID12345678.MERCHANT MOCK TEST.50000"
        val transaction = parseQrBarcodeTransaction(code).getOrNull()
        assertTrue(transaction!!.accountName == "BNI")
    }

    @Test
    fun `test when get random code, give error result`(){
        val transaction = parseQrBarcodeTransaction("Test")
        assertTrue(transaction.isLeft())
    }
}