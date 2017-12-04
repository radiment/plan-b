package com.epam.planb.transactions.dao;

import java.util.List;

import com.epam.planb.transactions.dao.entities.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Andrey Dyomin on 29.11.17.
 */
@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    List<Transaction> findByUserId(Long userId);
}
