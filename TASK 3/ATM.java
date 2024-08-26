import java.util.Scanner;

public class ATM{
    private BankAccount account;
    Scanner sc = new Scanner(System.in);

    public ATM(BankAccount account){
        this.account = account;
    }

    public void Menu(){
        System.out.println("\n================================================");
        System.out.println("Hello, Welcome to the ATM");
        System.out.println("\n1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.println("\nEnter your choice");
    }

    public void Withdraw(){
        System.out.print("\nAmount to withdraw: $");
        double amount = sc.nextDouble();
        boolean with_successful = account.withdraw(amount);
        if(with_successful)
            System.out.println("Withdrawl Successful. Your new Balance = $"+account.showBalance());
        else{
            System.out.println("\nTransaction failed.");
            System.out.println("Insufficient balance");
        }
    }

    public void Deposit(){
        System.out.print("\nAmount to deposit: $");
        double amount = sc.nextDouble();
        account.deposit(amount);
        System.out.println("Deposit Successful. Your new Balance = $"+account.showBalance());
    }

    public void checkBalance(){
        System.out.println("\nYour current balance is: $"+account.showBalance());
    }

    public void execute()
    {
        int choice;
        do{
            Menu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    Withdraw();
                    break;
                
                case 2:
                    Deposit();
                    break;

                case 3:
                    checkBalance();
                    break;

                case 4:
                    System.out.println("================================================");
                    System.out.println("Thank You");
                    System.out.println("================================================\n");
                    break;

                default:
                    System.out.println("Invalid Choice. Please choose the correct option.");
                    break;
            }
        }while(choice != 4);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(2000.0);
        ATM atm = new ATM(account);
        atm.execute();
    }
}