package com.spencer.jamy.transaction.service;

import com.spencer.jamy.transaction.domain.Purchase;
import com.spencer.jamy.transaction.repository.PurchaseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.stream.Stream;
import java.util.Optional;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;

    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    public Purchase save(Purchase purchase){
        return purchaseRepository.save(purchase);
    }
    public Iterable<Purchase> save(Iterable<Purchase> purchases){
        return purchaseRepository.saveAll(purchases);
    }
    public Optional<Purchase> findById(BigInteger id){
        return purchaseRepository.findById(id);
    }
    public Iterable<Purchase> findAll(){
        return purchaseRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Stream<Purchase> getHistory(long months){
        return purchaseRepository.findAllByPurchaseDateAfter(LocalDate.now().minusMonths(months));
    }
}
