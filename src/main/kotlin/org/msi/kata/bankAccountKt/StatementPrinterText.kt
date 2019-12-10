package com.msi.kata.bankaccount

import org.msi.kata.bankAccountKt.Statement
import org.msi.kata.bankAccountKt.StatementLine
import org.msi.kata.bankAccountKt.StatementPrinter
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