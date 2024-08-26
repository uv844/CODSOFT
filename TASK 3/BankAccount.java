public class BankAccount {
    private double balance;
    
    public BankAccount(double initial_Balance){
        this.balance = initial_Balance;    
    }

    public double showBalance(){
        return balance;
    }

    public void deposit(double amount){
        balance = balance + amount;
    }

    public boolean withdraw(double amount){
        if( balance < amount)
            return false;
        else{
            balance = balance - amount;
            return true;
        }
    }
}