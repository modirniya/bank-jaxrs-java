package dev.cyrus.service

import dev.cyrus.data.Repository
import dev.cyrus.model.Account

class AccountService {

    // TODO: Clean up

    private val accountsDataset = Repository.accounts;

    fun getAllAccounts(): List<Account> = accountsDataset.values.toList()

    fun getAccount(accountNumber: Int): Account = accountsDataset[accountNumber]!!

    fun addAccount(account: Account): Account {
        account.accountNumber = accountsDataset.size + 1
        accountsDataset[account.accountNumber] = account
        return account
    }

    fun updateAccount(accountNumber: Int, entryAccount: Account): Account? {
        if (accountNumber <= 0)
            return null
        entryAccount.accountNumber = accountNumber
        accountsDataset[accountNumber] = entryAccount
        return entryAccount
    }

    fun removeAccount(accountNumber: Int): Account? = accountsDataset.remove(accountNumber)


}