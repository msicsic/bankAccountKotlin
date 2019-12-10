package org.msi.kata.acceptance

import org.msi.kata.bankAccountKt.Money
import org.msi.kata.bankAccountKt.Statement
import org.msi.kata.bankAccountKt.StatementPrinter

class FakeStatementPrinter : StatementPrinter {
    var statement: Statement? = null

    fun getBalance(): Money = statement?.lines?.firstOrNull()?.balance ?: Money(0)

    override fun print(statement: Statement) {
        this.statement = statement
    }

}
