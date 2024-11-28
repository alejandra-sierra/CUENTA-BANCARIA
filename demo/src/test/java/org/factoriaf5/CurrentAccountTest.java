package org.factoriaf5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CurrentAccountTest {

    private CurrentAccount currentAccount;

    @BeforeEach
    void setUp() {
        currentAccount = new CurrentAccount(5000, 100);
    }

    @Test
    void testWithdrawWithinBalance() {
        boolean success = currentAccount.withdraw(3000); 
        assertTrue(success); 
        assertEquals(2000, currentAccount.balance); 
        assertEquals(1, currentAccount.withdrawals); 
        assertEquals(0, currentAccount.getOverdraft()); 
    }

    @Test
    void testWithdrawExceedingBalance() {
        boolean success = currentAccount.withdraw(6000); 
        assertTrue(success); 
        assertEquals(0, currentAccount.balance); 
        assertEquals(1000, currentAccount.getOverdraft()); 
        assertEquals(1, currentAccount.withdrawals); 
    }

    @Test
    void testMultipleWithdrawals() {
        currentAccount.withdraw(3000); 
        currentAccount.withdraw(2500); 
        assertEquals(0, currentAccount.balance);
        assertEquals(500, currentAccount.getOverdraft()); 
        assertEquals(2, currentAccount.withdrawals); 
    }

    @Test
    void testDepositWithoutOverdraft() {
        currentAccount.deposit(2000);
        assertEquals(7000, currentAccount.balance); 
        assertEquals(0, currentAccount.getOverdraft()); 
    }

    @Test
    void testDepositWithOverdraft() {
        currentAccount.withdraw(6000); 
        currentAccount.deposit(1500);
        assertEquals(0, currentAccount.getOverdraft()); 
        assertEquals(500, currentAccount.balance); 
    }

    @Test
    void testCurrentAccountInfo() {
        currentAccount.withdraw(6000);
        currentAccount.deposit(2000);
        currentAccount.CurrentAccountInfo();
        assertEquals(0, currentAccount.getOverdraft());
        assertEquals(1000, currentAccount.balance);
    }
}
