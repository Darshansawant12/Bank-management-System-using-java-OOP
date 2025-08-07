class SavingAccount extends BankAccount{
    private double interestRate;

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate){
        this.interestRate =interestRate;
    }
     
    public SavingAccount(int AccountNumber, String holdername,double balance, double interestRate){
        super(AccountNumber, "Saving", holdername, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest(int months){
        // calculate monthly interest rate from annual interest rate
        double monthlyInterestRate = interestRate / 12;
        // calculate interest for the given number of months
        double interest = getBalance()* monthlyInterestRate* months;
        // add interest to the balance
        setBalance(getBalance() + interest);

        System.out.println("Interest applied for" + months + "months:");
        System.out.println("Initial Balance:"+ (getBalance()- interest));
        System.out.println("Interest Rate:"+(interestRate * 100)+"%annually");
        System.out.println("Monthly Intrest Rate:"+(monthlyInterestRate* 100)+"%");
        System.out.println("Interest Applied:"+ interest);
        System.out.println("New balance after applying interest:$" + getBalance());
    }

}