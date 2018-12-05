package OneTwoThreeBet;

public class AddToBalance {
	private double balance;
	
	public AddToBalance()
	{
	}
	
	public void addBalance(double add)
	{
		this.balance += add;
	}

//	public double getBalance(double add) {
//		this.balance = this.balance + add;
//		return balance;
//	}
//
//	public void setBalance(double balance) {
//		this.balance = balance;
//	}
	
	public String toString()
	{
		String go = Double.toString(this.balance);
		return go;
	}

	
}
