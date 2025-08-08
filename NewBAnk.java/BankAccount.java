import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
class BankAccount{
     List<BankAccount> accounts= new ArrayList<>();
    private int AccountNumber;
    private String type;
    private String holdername;
    private double balance;

    BankAccount(int AccountNumber, String type, String holdername, double balance) {
        this.AccountNumber = AccountNumber;
        this.type = type;
        this.holdername = holdername;
        this.balance = balance;
    }
    public int getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.AccountNumber = accountNumber;
    }

    // Getter and Setter for type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Getter and Setter for holdername
    public String getHoldername() {
        return holdername;
    }

    public void setHoldername(String holdername) {
        this.holdername = holdername;
    }

    // Getter and Setter for balance
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    
    
    }
    public void createAccount(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Creating New Account");
        System.out.println("Enter Account Number:");
        AccountNumber = sc.nextInt();
        System.out.println("Enter account type(Saving/Current/loan):");
        type = sc.next();
        System.out.println("Enter Account Holder Name:");
        holdername = sc.next();
        System.out.println("Enter Initial Balance:");
        balance = sc.nextDouble();
        System.out.println("Account Created Successfully");
        BankAccount newAccount;
        if(type.equalsIgnoreCase("saving")){
            System.out.println("Enter interest rate in percentage:");
            double interestRate = sc.nextDouble();
            interestRate = interestRate / 100;// Convert percentage to decimal
            newAccount = new SavingAccount(AccountNumber, holdername, balance, interestRate);
        }
        else if(type.equalsIgnoreCase("Current")){
            newAccount = new CurrentAccount(AccountNumber,holdername,balance);
        }
        else if(type.equalsIgnoreCase("Loan")){
            System.out.println("Enter loan Amount:");
            double loanAmount = sc.nextDouble();
            System.out.println("Enter interest rate in percentage:");
            double interestRate = sc.nextDouble();
            System.out.println("Enter loan term in years:");
            int loanterm = sc.nextInt();
            interestRate = interestRate / 100;// Convert percentage to decimal
            newAccount = new LoanAccount(AccountNumber, holdername, loanAmount, interestRate, loanterm);
            
        }
        else{
            System.out.println("Invalid account type. Please enter either 'Saving','Current', or 'Loan.'");
            return;
        }

        accounts.add( newAccount );
        System.out.println("Account Created Successfully:"+ newAccount);

    }
    class CurrentAccount extends BankAccount{
        // private double overdraftLimit;

        public CurrentAccount(int AccountNumber, String holdername, double balance) {
            super(AccountNumber, "Current", holdername, balance);
            
        }
    }
    private BankAccount findaccount(int AccountNumber){
        for (BankAccount account : accounts){
            if (account.getAccountNumber()==(AccountNumber)){
                return account;
            }
        }
        return null;
    }

    public void displayAccounts(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Display account details");
        System.out.println("Enter account number:");
        int accountnumber = sc.nextInt();
        BankAccount account = findaccount (accountnumber);

        if(account != null)
        {
            account.displayAccountsdetails();
        }
        else
        {
            System.out.println("Account not found.");
        }
    }

    public void displayAccountsdetails() {
        System.out.println("Account Number: "       + getAccountNumber());
        System.out.println("Account Type: "         + getType());
        System.out.println("Account Holder Name: "  + getHoldername());
        System.out.println("Balance: "              + getBalance());
    }

    public void deposite(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Deposite amount");
        System.out.println("Enter account number:");
        int accountNumber = sc.nextInt();
        System.out.println("Enter deposite Amount:");
        double amount = sc.nextDouble();
         
        BankAccount account = findaccount(accountNumber);
        if (account!= null){
            account.deposite(amount);
        }
        else{
            System.out.println("Account not found.");
        }
    }

    public void deposite(double amount){
        balance += amount;
        System.out.println("Deposited:"+ amount);
    }

    public void withdraw(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Withdraw amount");
        System.out.println("Enter account number:");
        int accountNumber = sc.nextInt();
        System.out.println("Enter withdraw amount:");
        double amount = sc. nextDouble();

        BankAccount account = findaccount(accountNumber);
        if(account != null){
            account.withdraw(amount);
        }
        else{
            System.out.println("Account not found.");
        }
    }
    public boolean withdraw(double amount){
        if(balance >= amount){
            balance -=amount;
            System.out.println("Amount Withdrawn:"+ amount);
            return true;
        }else{
            System.out.println("Insufficient fund for withdrawal.");
            return false;
        }
    }

    public void applyInterest(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Apply interest ");
        System.out.println("Enter account number:");
        int accountNumber = sc.nextInt();
        System.out.println("Enter the month to apply interest for:");
        int months = sc. nextInt();

        BankAccount account =  findaccount(accountNumber);
        if(account instanceof SavingAccount){
            ((SavingAccount)account).applyInterest(months);
        }
        else{
            System.out.println("Account not found or not a saving account.");
        }
    }

    public void displayLoanDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Display Loan account details");
        System.out.println("Enter Account number:");
        int accountNumber = sc.nextInt();
        BankAccount account =  findaccount(accountNumber);
        if(account instanceof LoanAccount){
           ((LoanAccount)account).displayLoanDetails(); 
        }
        else{
            System.out.println("Account not found or not a loan account.");
        }
    }

    public void makeLoanPayment(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Loan Account details");
        System.out.println("Enter account Number:");
        int accountNumber = sc.nextInt();
         
        BankAccount account = findaccount( accountNumber);
        if(account instanceof LoanAccount){
            System.out.println("Enter payment Amount:");
            double paymentAmount = sc.nextDouble();
            ((LoanAccount)account).makepayment(paymentAmount);
        }
        else{
            System.out.println("Account not found or not a loan account.");
        }

    }

} 