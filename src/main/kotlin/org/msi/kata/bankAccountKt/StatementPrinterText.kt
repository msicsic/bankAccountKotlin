package org.msi.kata.bankAccountKt

import java.io.PrintStream
import java.time.format.DateTimeFormatter

class StatementPrinterText(private val pStream: PrintStream) : StatementPrinter {

    override fun print(statement: Statement) {
        statement.lines.forEach { line: StatementLine ->
            val strLine: String = line.type.toString() + " " +
                    line.date.format(DateTimeFormatter.ISO_DATE) + " " +
                    line.amount.amount + " " +
                    line.balance.amount
            pStream.println(strLine)
        }
    }

}