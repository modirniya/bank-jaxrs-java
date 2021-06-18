package dev.cyrus.data;

import dev.cyrus.model.Account

class Repository {
    companion object {
        val accounts = mutableMapOf<Int, Account>()
    }
}
