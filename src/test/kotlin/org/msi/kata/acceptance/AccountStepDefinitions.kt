package org.msi.kata.acceptance

import io.cucumber.java8.En
import org.junit.jupiter.api.Assertions
import org.msi.kata.bankAccountKt.Account
import org.msi.kata.bankAccountKt.Money


class AccountStepDefinitions : En {
    private lateinit var account: Account
    private val printer = FakeStatementPrinter()

    init {
        Given("^I have an empty account$") {
            account = Account()
        }

        When<Int>("I deposit {int} Euros") { amount: Int ->
            account.deposit(Money(amount))
        }

        Then<Int>("My balance should be {int} Euros") { amount: Int ->
            account.printStatement(printer)
            Assertions.assertEquals(Money(amount), printer.getBalance())
        }
    }

}
