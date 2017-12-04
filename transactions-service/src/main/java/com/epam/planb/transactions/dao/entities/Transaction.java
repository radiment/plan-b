package com.epam.planb.transactions.dao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
@Entity
public class Transaction {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private Long userId;
    private Long amount;
}
