
public class SavingsAccount extends BankAccount {
	public double rate = .025;
	public int savingsNumber = 0;
	
	public SavingsAccount(String name, double balance) {
		super(name, balance);
		String acctNumber = this.getAccountNumber();
		this.setAccountNumber(acctNumber + "-" + savingsNumber);
		savingsNumber++;
	}
	
	public SavingsAccount(SavingsAccount oldAccount, double amount) {
		super(oldAccount, amount);
		savingsNumber++;
		String acctNumber = this.getAccountNumber();
		String x = acctNumber.split("-")[0];
		
		
		this.setAccountNumber(x + "-" + savingsNumber);
	}
	
	public void postInterest() {
		double interest = this.getBalance() * (rate / 12);
		this.deposit(interest);
	}
	
	@Override
	public String getAccountNumber() {
		return super.getAccountNumber();
	}
}
