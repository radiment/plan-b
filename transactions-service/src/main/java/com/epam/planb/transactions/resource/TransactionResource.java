package com.epam.planb.transactions.resource;

import com.epam.planb.transactions.dao.entities.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Andrey Dyomin on 29.11.17.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResource {
    private Long id;
    private String name;
    private Long amount;

    public Transaction.TransactionBuilder toTransaction() {
        return Transaction.builder()
            .id(id)
            .name(name)
            .amount(amount);
    }

    public static TransactionResource fromTransaction(Transaction transaction) {
        return TransactionResource.builder()
            .id(transaction.getId())
            .name(transaction.getName())
            .amount(transaction.getAmount())
            .build();
    }
}
