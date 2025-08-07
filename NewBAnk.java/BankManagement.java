import java.util.Scanner;

class BankManagementSystem {
public static void main(String[] args) {
    BankManagementSystem b = new BankManagementSystem();
    
    b.run();
}
    public void run(){
        BankAccount ba = new BankAccount(null, null, null,0);
    Scanner sc = new Scanner(System.in);
     int choice = 0;
    do{
        System.out.println("1.create Account");
        System.out.println("2.display account details");
        System.out.println("3.Deposite amount");
        System.out.println("4. Withdraw amount");
        System.out.println("5.Apply interest to saving account");
        System.out.println("6.display loan account details");
        System.out.println("7.Make loan Payment");
        System.out.println("8.Exit");
         choice = sc.nextInt();
        switch (choice) 
        {
            case 1:
                ba.createAccount();
                break;
            case 2:
                ba.displayAccounts();
                break;
            case 3:
                ba.deposite();
                break;
            case 4:
                ba.withdraw();
                break;
            case 5:
                ba.applyInterest();
                break;
            case 6:
                // ba.displayLoanDetails();
                break;
            case 7:
                // ba.makeLoanPayment();
                break;
            case 8:
                System.out.println("Thank you for using the Bank Management System.");
                break;
            default:
                break;
        }
     
    }
    while (choice != 8);
}
}