class SavingAccount extends BankAccount{
    private double interestRate;
     
    public SavingAccount(int AccountNumber, String holdername,double balance, double interestRate){
        super(AccountNumber, "Saving", holdername, balance);
        this.interestRate = interestRate;
    }

}