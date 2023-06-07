package com.finances.infrastructure.entrypoint.request

import java.time.LocalDate

data class ExpenseSearchRequest (
    val amount : Double,
    val buyDate : String
) {
    var buyDateParse : LocalDate? = null

    init {
        buyDateParse = LocalDate.parse(buyDate)
    }
}