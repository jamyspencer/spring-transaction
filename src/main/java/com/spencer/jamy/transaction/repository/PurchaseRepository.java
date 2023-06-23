package com.spencer.jamy.transaction.repository;

import com.spencer.jamy.transaction.domain.Purchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, BigInteger> {
    Stream<Purchase> findAllByPurchaseDateAfter(LocalDate after);
}
