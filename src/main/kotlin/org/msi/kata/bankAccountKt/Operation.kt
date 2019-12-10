package org.msi.kata.bankAccountKt

import java.time.LocalDateTime

data class Operation(val money: Money, val date: LocalDateTime) {
}