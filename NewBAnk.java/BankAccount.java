import java.util.Scanner;

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
            newAccount = new SavingAccount(AccountNumber, type, holdername, balance, interestRate);
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
            newAccount = new LoanAccount(AccountNumber, type, holdername, balance, loanAmount, interestRate);
        }
        else{
            System.out.println("Invalid account type. Please enter either 'Saving','Current', or 'Loan.'");
        }

        accounts.add(newAccount);
        System.out.println("Account Created Successfully:"+ newAccount);

    }
    class CurrentAccount extends BankAccount{
        private double over draftLimit;

        public CurrentAccount(int AccountNumber, String holdername, double balance) {
            super(AccountNumber, "Current", holdername, balance);
            
        }
    }
}
    