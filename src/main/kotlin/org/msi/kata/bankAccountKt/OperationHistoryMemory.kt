package org.msi.kata.bankAccountKt

import org.msi.kata.bankAccountKt.utils.Entity

@Entity
class OperationHistoryMemory : OperationHistory {
    val operations = mutableListOf<Operation>()

    override fun add(operation: Operation) {
        operations.add(operation)
    }

    override fun getStatement(): Statement {
        var balance = Money(0)
        val lines = mutableListOf<StatementLine>()
        for (operation in operations) {
            balance += operation.amount
            lines.add(StatementLine(operation.type, operation.date, operation.amount, balance))
        }
        return Statement(lines.reversed())
    }

}