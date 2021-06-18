package dev.cyrus.resource;

import dev.cyrus.model.Transaction;
import dev.cyrus.service.TransactionService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResource {

    TransactionService service = new TransactionService();

    @GET
    public List<Transaction> getAllTransactions(@BeanParam TransactionsFilterBean bean,
                                                @PathParam("accountNumber") int accountNumber) {
        if (bean.getStart() > 0 || bean.getLength() > 0)
            return service.getTransactions(accountNumber, bean.getStart(), bean.getLength());
        else if (bean.getDeclined())
            return service.getDeclinedTransactions(accountNumber);
        else
            return service.getAllTransactions(accountNumber);
    }

    @POST
    public Transaction newTransaction(@PathParam("accountNumber") int accountNumber, Transaction transaction) {
        return service.addTransaction(transaction, accountNumber);
    }


    @GET
    @Path("/{transactionId}")
    public Transaction getSingleTransaction(
            @PathParam("accountNumber") int accountNumber,
            @PathParam("transactionId") int transactionId) {
        return service.getTransaction(accountNumber, transactionId);
    }
}
