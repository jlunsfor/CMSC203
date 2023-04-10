
public class CheckingAccount extends BankAccount {
	/**a transaction fee for checking accounts*/
	static final double FEE = 0.15;
	
	public CheckingAccount(String name, double amount) {
		super(name, amount);
		String acctNumber = this.getAccountNumber();
		this.setAccountNumber(acctNumber + "-10");
	}
	
	@Override
	public boolean withdraw(double amount) {
		amount += FEE;
		boolean completed = super.withdraw(amount);
		return completed;
	}

}
