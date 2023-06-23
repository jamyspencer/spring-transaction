package com.spencer.jamy.transaction.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Purchase {
    @Id
    @GeneratedValue
    private BigInteger id;
    private BigDecimal amount;
    @JsonFormat(pattern = "MM/dd/yyyy")
    private LocalDate purchaseDate;
    private static BigDecimal fifty = BigDecimal.valueOf(50);
    public Purchase(BigDecimal amount) {
        this.amount = amount;
    }

    public Purchase() {

    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Transient
    public BigDecimal getPoints() {
        int compare = this.amount.compareTo(Purchase.fifty);
        if (compare <= 0) {
            return BigDecimal.ZERO;
        }
        BigDecimal seive = this.amount.subtract(Purchase.fifty);
        compare = seive.compareTo(Purchase.fifty);
        if (compare <= 0) {
            return seive;
        }
        seive = seive.subtract(Purchase.fifty);
        return Purchase.fifty.add(seive.multiply(BigDecimal.valueOf(2)));
    }


//    A customer receives 2 points for every dollar spent over $100 in each transaction,
//    plus 1 point for every dollar spent between $50 and $100 in each transaction. (e.g., a $120 purchase = 2x$20 + 1x$50 = 90 points).
}
