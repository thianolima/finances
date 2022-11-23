package com.finances.core.port.input

import com.finances.core.model.Bank
import java.util.*

interface BankPort {
    fun save(bank: Bank): Bank
    fun existsByCodeAndId(code: String, id: String): Boolean
    fun delete(id: String)
    fun findById(id: String): Optional<Bank>
}