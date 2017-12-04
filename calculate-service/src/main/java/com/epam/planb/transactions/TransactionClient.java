package com.epam.planb.transactions;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Andrey Dyomin on 29.11.17.
 */
@FeignClient("transaction-service")
@RequestMapping("/{userId}/transactions")
public interface TransactionClient {

    @GetMapping
    List<Transaction> getTransactionsForUser(@PathVariable("userId") Long userId);

}
