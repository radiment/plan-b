package com.epam.planb.transactions;

import java.util.List;
import java.util.stream.Collectors;

import com.epam.planb.transactions.dao.TransactionRepository;
import com.epam.planb.transactions.resource.TransactionResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andrey Dyomin on 29.11.17.
 */
@RestController
@RequestMapping("/{userId}/transactions")
public class TransactionsService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionsService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping
    public List<TransactionResource> getTransactions(@PathVariable Long userId) {
        return transactionRepository.findByUserId(userId).stream()
            .map(TransactionResource::fromTransaction)
            .collect(Collectors.toList());
    }

    @PostMapping("/")
    public void addTransaction(@PathVariable Long userId, TransactionResource transaction) {
        transactionRepository.save(transaction.toTransaction().userId(userId).build());
    }

}
