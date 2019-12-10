package org.msi.kata.acceptance

import com.msi.kata.bankaccount.StatementPrinterText
import io.cucumber.datatable.DataTable
import io.cucumber.java8.En
import org.junit.jupiter.api.Assertions
import org.msi.kata.acceptance.DataTableConfigurer.COperation
import org.msi.kata.acceptance.DataTableConfigurer.CPrintedLine
import org.msi.kata.bankAccountKt.Account
import org.msi.kata.bankAccountKt.Money
import org.msi.kata.bankAccountKt.Operation
import org.msi.kata.bankAccountKt.OperationHistoryMemory
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.time.LocalDateTime
import java.util.function.Consumer


class AccountStepDefinitions : En {
    private lateinit var account: Account
    private val statement = OperationHistoryMemory()
    private val buffer = ByteArrayOutputStream()
    private val realPrinter = StatementPrinterText(PrintStream(buffer))
    private val printer = FakeStatementPrinter(realPrinter)
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

        Given<DataTable>("^make the following operations$") { table: DataTable ->
            val operations: List<COperation> = table.asList<COperation>(COperation::class.java)
            operations.forEach(Consumer<COperation> { operation: COperation ->
                if (operation.type == Operation.Type.DEPOSIT) {
                    account.deposit(operation.amount, operation.date)
                } else {
                    account.withdraw(operation.amount, operation.date)
                }
            })
        }

        When("^I ask for the statement$") {
            account.printStatement(printer)
        }

        Then<DataTable>("^I should see$") { table: DataTable ->
            val expected = table
                    .asList<Any>(CPrintedLine::class.java)
                    .joinToString(System.lineSeparator()) { obj: Any -> obj.toString() } + System.lineSeparator()
            Assertions.assertEquals(expected, String(buffer.toByteArray()))
        }

        Then<Int>("My balance should be {int} Euros") { amount: Int ->
            account.printStatement(printer)
            Assertions.assertEquals(Money(amount), printer.getBalance())
        }
    }

}
