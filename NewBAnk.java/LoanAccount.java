class LoanAccount extends BankAccount{
    private double loanAmount;
    private double interestRate;
    private int loanTerm;
    private double monthlyPayment;


public LoanAccount(int AccountNumber, String holdername, double loanAmount, double interestRate, int loanTerm){
    super(AccountNumber, "Loan",holdername,0.0);
    this.loanAmount = loanAmount;
    this.interestRate = interestRate;
    this.loanTerm = loanTerm;
    calculateMonthlyPayment();
}
private void calculateMonthlyPayment(){
    double monthlyPayment = interestRate /12;
     this.monthlyPayment = (loanAmount * monthlyPayment) /
                     (1 - Math.pow(1 + monthlyPayment, -loanTerm));
}
public void displayLoanDetails(){
    System.out.println("Loan Account Details:");
    System.out.println("Account Number: " + getAccountNumber());
    System.out.println("Holder Name: " + getHoldername());
    System.out.println("Loan Amount: " + loanAmount);
    System.out.println("Interest Rate: " + (interestRate * 100) + "%");
    System.out.println("Loan Term: " + loanTerm + " years");
    System.out.println("Monthly Payment: " + monthlyPayment);
}
public void makepayment(double paymentAmount){
    if(paymentAmount < monthlyPayment){
        System.out.println("Payment is higher than the monthly payment, adjusting loan balance...");
        loanAmount -= paymentAmount;
        System.out.println("payment made: $" + paymentAmount);

        if(paymentAmount >= monthlyPayment){
            System.out.println("Loan is fully paid:");
        }
        }
    }
}

