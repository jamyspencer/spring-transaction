package com.spencer.jamy.transaction.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseTest {
    @Test
    public void testGetPointsFrom49(){
        testGetPoints(49, 0);
    }
    @Test
    public void testGetPointsFrom50(){
        testGetPoints(50, 0);
    }
    @Test
    public void testGetPointsFrom51(){
        testGetPoints(51, 1);
    }

    @Test
    public void testGetPointsFrom100(){
        testGetPoints(100, 50);
    }
    @Test
    public void testGetPointsFrom101(){
        testGetPoints(101, 52);
    }
    @Test
    public void testGetPointsFrom120(){
        testGetPoints(120, 90);
    }
    @Test
    public void testGetPointsFrom140(){
        testGetPoints(140, 130);
    }


    private void testGetPoints(double purchaseAmount, double expected ) {
        this.testGetPoints(BigDecimal.valueOf(purchaseAmount), BigDecimal.valueOf(expected));
    }
    private void testGetPoints(BigDecimal purchaseAmount, BigDecimal expected ) {
        Purchase underTest = new Purchase(purchaseAmount);
        BigDecimal value = underTest.getPoints();
        assertTrue(expected.compareTo( value) == 0, "Expected value " + expected.toString() + " is not equal to " + value);
    }

    //    A customer receives 2 points for every dollar spent over $100 in each transaction,
//    plus 1 point for every dollar spent between $50 and $100 in each transaction. (e.g., a $120 purchase = 2x$20 + 1x$50 = 90 points).
}