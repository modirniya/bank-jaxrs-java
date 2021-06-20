package dev.cyrus.model;

import java.util.*
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement
class Transaction() {
    var isApproved: Boolean = false
    var title: String = ""
    var tag: String = ""
    var id: Int = 0
    var amount: Double = 0.0
    val transactionDate = Date()

    fun isApproved() {
        isApproved = true
    }

    fun isDeclined() = !isApproved

    constructor(title: String, tag: String, amount: Double) : this() {
        this.title = title
        this.tag = tag
        this.amount = amount
    }
}
