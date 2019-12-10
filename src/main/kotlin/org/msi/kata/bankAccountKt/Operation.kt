package org.msi.kata.bankAccountKt

import org.msi.kata.bankAccountKt.utils.Value
import java.time.LocalDateTime

@Value
data class Operation(val amount: Money, val date: LocalDateTime) {

    enum class Type {
        DEPOSIT
    }
}