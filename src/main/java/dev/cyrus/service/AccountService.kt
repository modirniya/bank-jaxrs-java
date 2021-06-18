package dev.cyrus.service

import dev.cyrus.data.Repository
import dev.cyrus.model.Account

class AccountService {

    private val mapAccounts = Repository.getAccounts();

    init {
        mapAccounts[1] = Account("Parham Modirniya", 1)
        mapAccounts[2] = Account("Neda Kamel", 2)
    }

    fun getAllAccounts(): List<Account> = mapAccounts.values.toList()

    fun getAccount(accountNumber: Int): Account = mapAccounts[accountNumber]!!

    fun addAccount(account: Account): Account {
        account.accountNumber = mapAccounts.size + 1
        mapAccounts[account.accountNumber] = account
        return account
    }

    fun updateAccount(account: Account): Account? {
        if (account.accountNumber <= 0)
            return null
        else
            mapAccounts[account.accountNumber] = account
        return account
    }

    fun removeAccount(accountNumber: Int): Account? = mapAccounts.remove(accountNumber)


}