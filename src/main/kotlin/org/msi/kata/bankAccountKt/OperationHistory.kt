package org.msi.kata.bankAccountKt

import java.time.LocalDateTime

interface OperationHistory {

    fun add(amount: Money, date: LocalDateTime)

    fun getStatement(): Statement
}