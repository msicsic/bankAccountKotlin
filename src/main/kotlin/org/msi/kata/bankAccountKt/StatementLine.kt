package org.msi.kata.bankAccountKt

import org.msi.kata.bankAccountKt.utils.Value
import java.time.LocalDateTime

@Value
data class StatementLine(
        val type: Operation.Type,
        val date: LocalDateTime,
        val amount: Money,
        val balance: Money
)