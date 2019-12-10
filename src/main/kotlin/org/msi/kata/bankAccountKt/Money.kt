package org.msi.kata.bankAccountKt

import java.math.BigDecimal

data class Money(val amount: BigDecimal) {
    constructor(amount: Int) : this(amount.toBigDecimal())
}