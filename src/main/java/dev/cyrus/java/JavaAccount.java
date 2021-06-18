/*
package dev.cyrus.java;

import dev.cyrus.model.Transaction;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement
public class JavaAccount {
    private String customerName;
    private int accountNumber;
    private double balance;
    private Date dateCreated;

    private Map<Integer, Transaction> transactionsHistory = new HashMap<>();

    public JavaAccount() {
    }

    public JavaAccount(String customerName, int accountNumber) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.dateCreated = new Date();
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @XmlTransient
    public Map<Integer, Transaction> getTransactionsHistory() {
        return transactionsHistory;
    }

    public void setTransactionsHistory(Map<Integer, Transaction> transactionsHistory) {
        this.transactionsHistory = transactionsHistory;
    }
}
*/
