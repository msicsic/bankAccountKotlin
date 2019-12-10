package org.msi.kata.bankAccountKt

import com.nhaarman.mockitokotlin2.inOrder
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

internal class AccountShould {

    @Test
    fun `deposit 100 added in history`() {
        // GIVEN
        val history = mock<OperationHistory>()
        val account = Account(history)
        val now = LocalDateTime.now()

        // WHEN
        account.deposit(Money(100), now)

        // THEN
        verify(history).add(Operation(Money(100), now))
    }

    @Test
    fun `deposit 100 and 200 added in history`() {
        // GIVEN
        val history = mock<OperationHistory>()
        val account = Account(history)
        val now = LocalDateTime.now()

        // WHEN
        account.deposit(Money(100), now)
        account.deposit(Money(200), now)

        // THEN
        inOrder(history) {
            verify(history).add(Operation(Money(100), now))
            verify(history).add(Operation(Money(200), now))
        }

    }

}