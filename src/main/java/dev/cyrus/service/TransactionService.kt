package dev.cyrus.service

import dev.cyrus.data.Repository
import dev.cyrus.model.Transaction

class TransactionService {

    private val mapAccounts = Repository.getAccounts();

    fun getAllTransactions(accountNumber: Int): List<Transaction> =
        mapAccounts[accountNumber]!!.transactionsHistory.values.toList()

    fun getTransactions(accountNumber: Int, start: Int, size: Int): List<Transaction> {
        val result = mutableListOf<Transaction>()
        val rawTransactions = getAllTransactions(accountNumber)
        var counter = 0
        val len = if (size > 0) size else rawTransactions.size - start + 1
        for (element in rawTransactions) {
            if (element.id >= start) {
                result.add(element)
                counter++
            }
            if (counter >= len)
                break
        }
        return result
    }

    fun getDeclinedTransactions(accountNumber: Int): List<Transaction> {
        val result = mutableListOf<Transaction>()
        val rawTransactionsList = getAllTransactions(accountNumber)
        for (element in rawTransactionsList)
            if (!element.isApproved)
                result.add(element)
        return result
    }

    fun getTransaction(accountNumber: Int, transactionId: Int): Transaction =
        getAllTransactions(accountNumber)[transactionId]

    fun addTransaction(transaction: Transaction, accountNumber: Int): Transaction {
        val account = mapAccounts[accountNumber]
        val transactionsDataset = account!!.transactionsHistory
        transaction.id = transactionsDataset.size + 1
        if (transaction.tag != "deposit")
            transaction.amount *= -1
        if (account.balance + transaction.amount >= 0) {
            account.balance += transaction.amount
            transaction.isApproved = true
        }
        transactionsDataset[transaction.id] = transaction
        return transaction
    }

}