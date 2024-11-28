package org.factoriaf5;

import java.util.function.BooleanSupplier;

public class SavingsAccount extends Account {
    private boolean isActive;
    public boolean getIsActive() {
        return isActive;
    }

    public SavingsAccount(float balance, float annualInterestRate) {
        super(balance, annualInterestRate); 
        this.isActive = balance >= 10000;
    }

    @Override
    public void deposit(float amount) {
        if (isActive) {
            super.deposit(amount);
        }
        updateAccountStatus();
    }

    @Override
    public boolean withdraw(float amount) {
        if (isActive) {
            boolean success = super.withdraw(amount); 
            updateAccountStatus(); 
            return success;
        }
        return false;
    }

    @Override
    public void monthlyStatement() {
        if (withdrawals > 4) { 
            fee += (withdrawals - 4) * 1000; 
        }
        super.monthlyStatement();
        updateAccountStatus();
    }

    private void updateAccountStatus() {
        isActive = balance >= 10000; 
    }

    
    public void SavingsInfo() {
        
        System.out.println("balance: " + balance);
        System.out.println("transacciones: "+ withdrawals + deposits);
        System.out.println("cuotas mensuales: "+ fee);
    }

    public BooleanSupplier isActive() {
        throw new UnsupportedOperationException("Unimplemented method 'isActive'");
    }
}
