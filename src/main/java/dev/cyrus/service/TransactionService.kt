package dev.cyrus.service

import dev.cyrus.data.Repository
import dev.cyrus.model.Transaction

class TransactionService {

    private val dataset = Repository.centralAccountsDataset;

    fun getAllTransactionsFor(accountNumber: Int): List<Transaction> =
        dataset[accountNumber]!!.transactionsHistory.values.toList()

    fun getTransactions(accountNumber: Int, fromIndex: Int, forLengthOf: Int): List<Transaction> {
        val tempTransactionsList = mutableListOf<Transaction>()
        val rawTransactionsList = getAllTransactionsFor(accountNumber)
        var loopCounter = 0
        val transactionsQuantity = if (forLengthOf > 0) forLengthOf else rawTransactionsList.size - fromIndex + 1
        for (eachTransaction in rawTransactionsList) {
            if (eachTransaction.id >= fromIndex) {
                tempTransactionsList.add(eachTransaction)
                loopCounter++
            }
            if (loopCounter >= transactionsQuantity)
                break
        }
        return tempTransactionsList
    }

    fun getDeclinedTransactions(accountNumber: Int): List<Transaction> {
        val unapprovedTransactionsList = mutableListOf<Transaction>()
        val rawTransactionsList = getAllTransactionsFor(accountNumber)
        for (eachTransaction in rawTransactionsList)
            if (eachTransaction.isDeclined())
                unapprovedTransactionsList.add(eachTransaction)
        return unapprovedTransactionsList
    }

    fun getSingleTransaction(accountNumber: Int, transactionId: Int): Transaction =
        getAllTransactionsFor(accountNumber)[transactionId]

    fun addTransaction(transaction: Transaction, accountNumber: Int): Transaction {
        val account = dataset[accountNumber]
        val transactionsDataset = account!!.transactionsHistory
        transaction.id = transactionsDataset.size + 1
        if (transaction.tag != "deposit")
            transaction.amount *= -1
        val currentBalance = account.balance + transaction.amount
        if (currentBalance >= 0.0) {
            transaction.isApproved()
            account.balance = currentBalance
        }
        transactionsDataset[transaction.id] = transaction
        return transaction
    }

}