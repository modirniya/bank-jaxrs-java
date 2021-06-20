package dev.cyrus.data;

import dev.cyrus.model.Account

class Repository {
    companion object {
        val centralAccountsDataset = mutableMapOf<Int, Account>()
    }
}
