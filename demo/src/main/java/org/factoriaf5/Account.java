package org.factoriaf5;

public class Account {
    protected float balance;
    protected int deposits = 0; 
    protected int withdrawals = 0; 
    protected float annualRate; 
    protected float fee = 0; 

    public Account(float balance, float annualRate) {
        this.balance = balance;
        this.annualRate = annualRate;
    }

    public void deposit(float amount) {
        if (amount > 0) { 
            balance += amount; 
            deposits++; 
            
        }
    }

    public boolean withdraw(float amount) {
        if (amount > 0 && amount <= balance) { 
            balance -= amount; 
            withdrawals++; 
            return true;
        }
        return false; 
    }

    public float calculationFee() {
        float monthlyInterest = (annualRate / 12) * balance / 100; 
        balance += monthlyInterest; 
        return monthlyInterest; 
    }

    public void monthlyStatement() {
        balance -= fee; 
        calculationFee(); 
    }

    public void AccountInfo() {
        
        System.out.println("balance: " + balance);
        System.out.println("numero de ingresos: "+ deposits);
        System.out.println("retiradas de dinero: "+ withdrawals);
        System.out.println("interes anual: "+ annualRate);
        System.out.println("cuotas mensuales: "+ fee);
    }
    

}

