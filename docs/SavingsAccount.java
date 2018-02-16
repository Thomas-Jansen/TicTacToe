public class SavingsAccount {
    private int balance;
    private int initialBalance;
    
    public SavingsAccount() {
        balance = 0;
    }
    
    public SavingsAccount(int initialBalance) {
        initialBalance = initialBalance;
    }
    
    public void greet() {
        System.out.println("Hello");
    }
    
    public void showBalance() {
        System.out.println(balance);
    }
    
    public void deposit(int howMuch) {
        if (howMuch < 0) {
            System.out.println("deposit is negative");
        }
        else
            balance = balance + howMuch;
    }
    
    public void withdraw(int howMuch) {
        if (howMuch < 0) {
            System.out.println("Withdraw is negative");
        }
        else if (balance - howMuch < 0) {
            System.out.println("Not enough funds");
        }
        else
            balance = balance - howMuch;
    }
}