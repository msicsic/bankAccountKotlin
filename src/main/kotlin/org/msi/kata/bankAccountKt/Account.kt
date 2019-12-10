package org.msi.kata.bankAccountKt

import org.msi.kata.bankAccountKt.utils.Entity
import java.time.LocalDateTime

@Entity
class Account(val history: OperationHistory) {
    fun deposit(amount: Money, date: LocalDateTime) {
        history.add(Operation(amount, date))
    }

    fun withdraw(amount: Money, date: LocalDateTime) {
        history.add(Operation(amount.negate(), date))
    }

    fun printStatement(printer: StatementPrinter) {
        printer.print(history.getStatement())
    }

}