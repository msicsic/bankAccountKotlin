package org.msi.kata.acceptance

import io.cucumber.java8.En
import org.junit.jupiter.api.Assertions
import org.msi.kata.bankAccountKt.Account
import org.msi.kata.bankAccountKt.Money
import org.msi.kata.bankAccountKt.OperationHistory
import org.msi.kata.bankAccountKt.OperationHistoryMemory
import java.time.LocalDateTime


class AccountStepDefinitions : En {
    private lateinit var account: Account
    private val statement = OperationHistoryMemory()
    private val printer = FakeStatementPrinter()
    private var date = LocalDateTime.now()

    init {
        Given("^I have an empty account$") {
            account = Account(statement)
        }

        When<Int>("I deposit {int} Euros") { amount: Int ->
            date = LocalDateTime.now()
            account.deposit(Money(amount), date)
        }

        When<Int>("I withdraw {int} Euros") { amount: Int ->
            date = LocalDateTime.now()
            account.withdraw(Money(amount), date)
        }

        Then<Int>("My balance should be {int} Euros") { amount: Int ->
            account.printStatement(printer)
            Assertions.assertEquals(Money(amount), printer.getBalance())
        }
    }

}
