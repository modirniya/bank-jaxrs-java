/*
package dev.cyrus.java;

import dev.cyrus.model.Account;
import dev.cyrus.resource.TransactionResource;
import dev.cyrus.service.AccountService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("accounts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JavaAccountResource {

    AccountService service = new AccountService();

    @GET
    public List<Account> getAllAccounts() {
        return service.getAllAccounts();
    }

    @GET
    @Path("/{accountNumber}")
    public Account getAccount(@PathParam("accountNumber") int accountNumber) {
        return service.getAccount(accountNumber);
    }

    @POST
    public Account addAccount(Account account) {
        return service.addAccount(account);
    }

    @PUT
    @Path("/{accountNumber}")
    public Account updateAccount(@PathParam("accountNumber") int accountNumber, Account account) {
        account.setAccountNumber(accountNumber);
        return service.updateAccount(account);
    }

    @DELETE
    @Path("/{accountNumber}")
    public Account removeAccount(@PathParam("accountNumber") int accountNumber) {
        return service.removeAccount(accountNumber);
    }

    @Path("/{accountNumber}/transaction")
    public TransactionResource getTransactionResource(@PathParam("accountNumber") int accountNumber) {
        return new TransactionResource();
    }

}
*/
