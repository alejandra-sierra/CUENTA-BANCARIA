package org.factoriaf5;

public class CurrentAccount extends Account {
    private float overdraft = 0; 

    public CurrentAccount(float balance, float fee) {
        super(balance, fee);
    }

    @Override
    public boolean withdraw(float amount) {
        if (amount > balance) {
            overdraft += (amount - balance); 
            balance = 0;
            withdrawals++; 
            return true;
        } else if (amount > 0) { 
            balance -= amount;
            withdrawals++;
            return true;
        }
        return false;
    }
    public float getOverdraft() {
        return overdraft;
    }

    @Override
    public void deposit(float amount) {
        if (overdraft > 0) { 
            float coverOverdraft = Math.min(amount, overdraft);
            overdraft -= coverOverdraft;
            amount -= coverOverdraft; 
        }
        super.deposit(amount);
    }

    
    public void CurrentAccountInfo() {
        
        System.out.println("balance: " + balance);
        System.out.println("transacciones: "+ withdrawals + deposits);
        System.out.println("cuotas mensuales: "+ fee);
        System.out.println("deuda: "+ overdraft);
    }
    
}
