package org.msi.kata.bankAccountKt

import org.msi.kata.bankAccountKt.utils.Value

@Value
data class Statement(val lines: List<StatementLine>) {

}