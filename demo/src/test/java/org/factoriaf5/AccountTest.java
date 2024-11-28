package org.factoriaf5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class AccountTest {

    private Account account;

   @Test
    void testDeposit() {
        account.deposit(500); 
        assertEquals(1500, account.balance); 
        assertEquals(1, account.deposits); 
    }

    @Test
    void testDepositNegativeAmount() {
        account.deposit(-100);
        assertEquals(1000, account.balance);
        assertEquals(0, account.deposits); 
    }

    @Test
    void testWithdraw() {
        boolean result = account.withdraw(300);
        assertTrue(result);
        assertEquals(700, account.balance); 
        assertEquals(1, account.withdrawals); 
    }

    @Test
    void testWithdrawInsufficientFunds() {
        boolean result = account.withdraw(1500); 
        assertFalse(result); 
        assertEquals(1000, account.balance); 
        assertEquals(0, account.withdrawals); 
    }

    @Test
    void testCalculationFee() {
        float interest = account.calculationFee(); 
        assertEquals(4.17, interest, 0.01); 
        assertEquals(1004.17, account.balance, 0.01); 
    }

    @Test
    void testMonthlyStatement() {
        account.fee = 10;
        account.monthlyStatement(); 
        assertEquals(994.125, account.balance, 0.01);
    }

    @Test
    void testAccountInfo() {
        account.AccountInfo(); 
        assertEquals(1000, account.balance); 
        assertEquals(0, account.deposits); 
        assertEquals(0, account.withdrawals);
    }
}
