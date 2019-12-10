package org.msi.kata.bankAccountKt

import org.msi.kata.bankAccountKt.utils.Entity

@Entity
class OperationHistoryMemory : OperationHistory {

    override fun add(operation: Operation) {

    }

    override fun getStatement(): Statement {
        return Statement(listOf())
    }

}