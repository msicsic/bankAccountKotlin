package org.msi.kata.bankAccountKt

import org.msi.kata.bankAccountKt.utils.Value
import java.time.LocalDateTime

@Value
data class Operation(val amount: Money, val date: LocalDateTime) {
    val type get() = if (amount.amount >= 0.toBigDecimal()) Type.DEPOSIT else Type.WITHDRAWAL

    enum class Type {
        DEPOSIT, WITHDRAWAL
    }
}