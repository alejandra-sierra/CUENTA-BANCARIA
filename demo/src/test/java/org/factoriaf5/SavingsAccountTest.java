package org.factoriaf5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SavingsAccountTest {

    private SavingsAccount savingsAccount;

    @BeforeEach
    void setUp() {
        savingsAccount = new SavingsAccount(12000, 5);
    }

    @Test
    void testInitialAccountStatus() {
        assertTrue(savingsAccount.getIsActive());
    }

    @Test
    void testDepositOnActiveAccount() {
        savingsAccount.deposit(2000); 
        assertEquals(14000, savingsAccount.balance); 
        assertTrue(savingsAccount.getIsActive()); 
    }

    @Test
    void testDepositOnInactiveAccount() {
        savingsAccount = new SavingsAccount(8000, 5);
        assertFalse(savingsAccount.getIsActive()); 
        savingsAccount.deposit(2000); 
        assertEquals(8000, savingsAccount.balance); 
        assertFalse(savingsAccount.getIsActive()); 
    }

    @Test
    void testWithdrawOnActiveAccount() {
        boolean success = savingsAccount.withdraw(3000); 
        assertTrue(success); 
        assertEquals(9000, savingsAccount.balance); 
        assertFalse(savingsAccount.getIsActive()); 
    }

    @Test
    void testWithdrawOnInactiveAccount() {
        savingsAccount = new SavingsAccount(9000, 5); 
        assertFalse(savingsAccount.getIsActive()); 
        boolean success = savingsAccount.withdraw(1000); 
        assertFalse(success); 
        assertEquals(9000, savingsAccount.balance);
    }

    @Test
    void testMonthlyStatementWithPenalty() {
        savingsAccount.withdraw(1000); 
        savingsAccount.withdraw(1000);  
        savingsAccount.withdraw(1000);  
        savingsAccount.withdraw(1000);  
        savingsAccount.withdraw(1000);
        savingsAccount.monthlyStatement(); 
        assertEquals(9037.5, savingsAccount.balance, 0.01); 
        assertFalse(savingsAccount.getIsActive());
    }

    @Test
    void testMonthlyStatementWithoutPenalty() {
        savingsAccount.withdraw(1000); 
        savingsAccount.withdraw(1000); 
        savingsAccount.monthlyStatement(); 
        assertEquals(10041.6669921875, savingsAccount.balance, 0.01); 
        assertTrue(savingsAccount.getIsActive()); 
    }

    @Test
    void testSavingsInfo() {
        savingsAccount.SavingsInfo();
        assertEquals(12000, savingsAccount.balance); 
        assertTrue(savingsAccount.getIsActive()); 
    }
}
