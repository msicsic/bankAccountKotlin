package org.msi.kata.acceptance

import io.cucumber.core.api.TypeRegistry
import io.cucumber.core.api.TypeRegistryConfigurer
import io.cucumber.datatable.DataTableType
import io.cucumber.datatable.TableEntryTransformer
import org.msi.kata.bankAccountKt.Money
import org.msi.kata.bankAccountKt.Operation
import java.time.LocalDateTime
import java.util.*

class DataTableConfigurer : TypeRegistryConfigurer {

    override fun configureTypeRegistry(registry: TypeRegistry) {
        registry.defineDataTableType(DataTableType(COperation::class.java, TableEntryTransformer { entry: Map<String, String> ->
            COperation(
                    type = Operation.Type.valueOf(entry["operation"]!!),
                    amount = Money(entry["amount"]!!.toInt()),
                    date = LocalDateTime.parse(entry["date"]+"T00:00:00")
            )
        } as TableEntryTransformer<COperation>))

        registry.defineDataTableType(DataTableType(CPrintedLine::class.java, TableEntryTransformer { entry: Map<String, String> ->
            CPrintedLine(
                    operation = entry["operation"],
                    date = entry["date"],
                    amount = entry["amount"],
                    balance = entry["balance"]
            )
        } as TableEntryTransformer<CPrintedLine>))
    }

    override fun locale() = Locale.ENGLISH

    internal class COperation(val type: Operation.Type, val amount: Money, val date: LocalDateTime)

    internal class CPrintedLine(var operation: String?, var date: String?, var amount: String?, var balance: String?) {
        override fun toString() = "$operation $date $amount $balance"
    }
}