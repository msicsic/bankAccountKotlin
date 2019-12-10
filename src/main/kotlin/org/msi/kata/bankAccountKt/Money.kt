package org.msi.kata.bankAccountKt

import org.msi.kata.bankAccountKt.utils.Value
import java.math.BigDecimal

@Value
data class Money(val amount: BigDecimal) {

    operator fun plus(amount: Money) = Money(this.amount + amount.amount)
    fun negate() = Money(this.amount.negate())

    constructor(amount: Int) : this(amount.toBigDecimal())
}