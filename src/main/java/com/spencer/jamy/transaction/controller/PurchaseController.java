package com.spencer.jamy.transaction.controller;

import com.spencer.jamy.transaction.domain.Purchase;
import com.spencer.jamy.transaction.service.PurchaseService;
import java.util.stream.Stream;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping(path={"","/"})
    public ResponseEntity<Purchase> handlePurchasePost(@RequestBody Purchase purchase){
        return ResponseEntity.ok(purchaseService.save(purchase));
    }
    @PostMapping(path={"/bulk","/bulk/"})
    public ResponseEntity<Iterable<Purchase>> handleBulkPurchasePost(@RequestBody List<Purchase> purchases){
        return ResponseEntity.ok(purchaseService.save(purchases));
    }

    @GetMapping(path = {"","/"})
    public ResponseEntity<Iterable<Purchase>> getPurchases() {
        Iterable<Purchase> purchase = purchaseService.findAll();
        return ResponseEntity.ok(purchase);
    }
    @GetMapping("/history/{months}")
    public ResponseEntity<Iterable<Purchase>> getHistory(@PathVariable("months")long months) {
        List<Purchase> purchases = purchaseService.getHistory(months).toList();
        return ResponseEntity.ok(purchases);
    }
    @GetMapping("/history/{months}/total")
    public ResponseEntity<String> getHistoryTotal(@PathVariable("months")long months) {
        Stream<Purchase> purchases = purchaseService.getHistory(months);
        BigDecimal total = purchases.map(purchase->purchase.getPoints()).reduce(BigDecimal.ZERO,(acc, points)-> acc.add(points));
        return ResponseEntity.ok("{ \"total\":\""+ total.toString() +"\"}");
    }
    @GetMapping("/{id}")
    public ResponseEntity<Purchase> getPurchaseById(@PathVariable("id")long id) {
        Optional<Purchase> purchase = purchaseService.findById(BigInteger.valueOf(id));
        return ResponseEntity.of(purchase);
    }
}
