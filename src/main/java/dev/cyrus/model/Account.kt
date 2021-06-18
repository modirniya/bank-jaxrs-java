package dev.cyrus.model

import java.util.*
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
class Account() {
    var customerName: String = ""
    var accountNumber: Int = 0
    var balance: Double = 0.0
    var dateCreated = Date()

    val transactionsHistory = mutableMapOf<Int, Transaction>()

    constructor(customerName: String, accountNumber: Int) : this() {
        this.customerName = customerName
        this.accountNumber = accountNumber
    }
}

