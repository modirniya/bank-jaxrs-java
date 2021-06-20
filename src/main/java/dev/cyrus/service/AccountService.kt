package dev.cyrus.service

import dev.cyrus.data.Repository
import dev.cyrus.model.Account

class AccountService {

    private val dataset = Repository.centralAccountsDataset;

    fun getAllAccounts(): List<Account> = dataset.values.toList()

    fun getAccount(accountNumber: Int): Account = dataset[accountNumber]!!

    fun addAccount(account: Account): Account {
        account.accountNumber = dataset.size + 1
        dataset[account.accountNumber] = account
        return account
    }

    fun updateAccount(accountNumber: Int, entryAccount: Account): Account? {
        if (accountNumber <= 0)
            return null
        entryAccount.accountNumber = accountNumber
        dataset[accountNumber] = entryAccount
        return entryAccount
    }

    fun removeAccount(accountNumber: Int): Account? = dataset.remove(accountNumber)

}