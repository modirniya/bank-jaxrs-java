@file:Suppress("UnresolvedRestParam")

package dev.cyrus.resource;

import dev.cyrus.model.Transaction
import dev.cyrus.service.TransactionService
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class TransactionResource(private val accountNumber: Int) {

    private val service = TransactionService()

    @GET
    fun getAllTransactions(
        @BeanParam bean: TransactionsFilterBean
    ): List<Transaction> =
        if (bean.start > 0 || bean.length > 0)
            service.getTransactions(accountNumber, bean.start, bean.length)
        else if (bean.declined)
            service.getDeclinedTransactions(accountNumber)
        else
            service.getAllTransactions(accountNumber)

    @POST
    fun newTransaction(transaction: Transaction) =
        service.addTransaction(transaction, accountNumber)

    @GET
    @Path("/{transactionId}")
    fun getSingleTransaction(
        @PathParam("/transactionId") transactionId: Int
    ) = service.getSingleTransaction(accountNumber, transactionId)
}


