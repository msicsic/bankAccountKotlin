package org.msi.kata.bankAccountKt

import org.msi.kata.bankAccountKt.utils.Entity
import java.time.LocalDateTime

@Entity
class OperationHistoryMemory : OperationHistory {
    val operations = mutableListOf<Operation>()

    override fun add(amount: Money, date: LocalDateTime) {
        operations.add(Operation(amount, date))
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