package org.msi.kata.bankAccountKt

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

internal class OperationHistoryMemoryShould {

    @Test
    fun `deposit 100 added to statement`() {
        // GIVEN
        val history = OperationHistoryMemory()
        val now = LocalDateTime.now()
        history.add(Operation(Money(100), now))

        // WHEN
        val statement = history.getStatement()

        // THEN
        assertEquals(1, statement.lines.size)
        assertEquals(StatementLine(Operation.Type.DEPOSIT, now, Money(100), Money(100)), statement.lines[0])
    }

    @Test
    fun `deposit 100 and 200 added to statement in reverse order`() {
        // GIVEN
        val history = OperationHistoryMemory()
        val now = LocalDateTime.now()
        history.add(Operation(Money(100), now))
        history.add(Operation(Money(200), now))

        // WHEN
        val statement = history.getStatement()

        // THEN
        assertEquals(2, statement.lines.size)
        assertEquals(StatementLine(Operation.Type.DEPOSIT, now, Money(200), Money(300)), statement.lines[0])
        assertEquals(StatementLine(Operation.Type.DEPOSIT, now, Money(100), Money(100)), statement.lines[1])
    }
}