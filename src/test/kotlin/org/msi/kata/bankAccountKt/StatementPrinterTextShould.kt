package org.msi.kata.bankAccountKt

import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.io.PrintStream
import java.time.LocalDateTime

class StatementPrinterTextShould {

    @Test
    fun deposit_100() {
        // GIVEN
        val pStream = Mockito.mock(PrintStream::class.java)
        val printer = StatementPrinterText(pStream)
        val date = LocalDateTime.of(2010, 10, 1, 0, 0)
        val line1 = StatementLine(Operation.Type.DEPOSIT, date, Money(100), Money(100))
        val statement = Statement(listOf(line1))

        // WHEN
        printer.print(statement)

        // THEN
        Mockito.verify(pStream, times(1)).println("DEPOSIT 2010-10-01 100 100")
    }

    @Test
    fun deposit_100_and_200() {
        // GIVEN
        val pStream = Mockito.mock(PrintStream::class.java)
        val printer = StatementPrinterText(pStream)
        val date = LocalDateTime.of(2010, 10, 1, 0, 0)
        val line1 = StatementLine(Operation.Type.DEPOSIT, date, Money(100), Money(100))
        val line2 = StatementLine(Operation.Type.DEPOSIT, date, Money(200), Money(300))
        val statement = Statement(listOf(line2, line1))

        // WHEN
        printer.print(statement)

        // THEN
        verify(pStream, times(1)).println("DEPOSIT 2010-10-01 100 100")
        verify(pStream, times(1)).println("DEPOSIT 2010-10-01 200 300")
    }
}