package testDomePractices;

/*
check test class for this question.

* Using JUnit 4's Assert class, write tests for the Account class that cover the following cases:

The deposit and withdraw methods will not accept negative numbers.
Account cannot overstep its overdraft limit.
The deposit and withdraw methods will deposit or withdraw the correct amount, respectively.
The withdraw and deposit methods return the correct results.
* */
public class Account {
    private double balance;
    private double overdraftLimit;

    public Account(double overdraftLimit) {
        this.balance = 0;
        this.overdraftLimit = overdraftLimit > 0 ? overdraftLimit : 0;
    }

    public boolean deposit(double amount) {
        if(amount >= 0) {
            this.balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if(this.balance - amount >= -this.overdraftLimit && amount >= 0) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }
}
