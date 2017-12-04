package com.epam.planb.calculate;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.epam.planb.transactions.Transaction;
import com.epam.planb.transactions.TransactionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Andrey Dyomin on 29.11.17.
 */
@RestController
@RequestMapping("/{userId}/calculates")
public class CalculateService {

    private TransactionClient transactionClient;

    @Autowired
    public CalculateService(TransactionClient transactionClient) {
        this.transactionClient = transactionClient;
    }

    @GetMapping("/balance")
    public Map<String, Long> calcBalanceFor(@PathVariable Long userId) {
        List<Transaction> transactions = transactionClient.getTransactionsForUser(userId);
        long sum = transactions.stream().mapToLong(Transaction::getAmount).sum();
        return Collections.singletonMap("balance", sum);
    }
}
