@file:Suppress("UnresolvedRestParam")

package dev.cyrus.resource;

import dev.cyrus.model.Account
import dev.cyrus.service.AccountService
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/accounts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class AccountResource {

    private val service = AccountService()

    @GET
    fun getAllAccounts(): List<Account> = service.getAllAccounts()

    @POST
    fun addAccount(account: Account) = service.addAccount(account)

    @GET
    @Path(value = "/{accountNumber}")
    fun getAccount(@PathParam("accountNumber") accountNumber: Int)
            : Account = service.getAccount(accountNumber)

    @PUT
    @Path("/{accountNumber}")
    fun updateAccount(@PathParam("accountNumber") accountNumber: Int, account: Account):
            Account? = service.updateAccount(accountNumber, account)

    @DELETE
    @Path("/{accountNumber}")
    fun removeAccount(@PathParam("accountNumber") accountNumber: Int) =
        service.removeAccount(accountNumber)

    @Path("/{accountNumber}/transaction")
    fun getTransactionResource(@PathParam("accountNumber") accountNumber: Int) = TransactionResource(accountNumber)
}
