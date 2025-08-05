import java.util.Scanner;

class BankManagementSystem {
public static void main(String[] args) {
    BankManagementSystem b = new BankManagementSystem();
    b.run();
}
    public void run(){
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
                 
                break;
            case 2:
             
                break;
            case 3:
             
                break;
            case 4:
                
                break;
            case 5:
                
                break;
            case 6:
                
                break;
            case 7:
                
                break;
            case 8:
               
                break;
            default:
                break;
        }
     
    }
    while (choice != 8);
}
}