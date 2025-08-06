class LoanAccount extends BankAccount{
    private double loanAmount;
    private double interestRate;
    private int loanTerm;
    private double monthlyPayment;

}
public LoanAccount(int AccountNumber, String holdername, double loanAmount, double interestRate, int loanTerm){
    super(AccountNumber, "Loan",holdername,0.0);
    this.loanAmount = loanAmount;
    this.interestRate = interestRate;
    this.loanTerm = loanTerm;
    calculateMonthlyPayment();
}
private void calculateMonthlyPayment(){
    double monthlyPayment = interestRate /12;
    monthlyPayment = (loanAmount * monthlyPayment) /
                     (1 - Math.pow(1 + monthlyPayment, -loanTerm));
}