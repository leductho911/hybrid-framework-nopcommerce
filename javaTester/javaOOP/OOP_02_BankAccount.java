package javaOOP;

public class OOP_02_BankAccount {
	private int accountNumber;
	private String accountOwner;
	private double balance;

	public OOP_02_BankAccount(int accountNumber, String accountOwner, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.accountOwner = accountOwner;
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double depositMoney(double amount) {
		return this.balance += amount;
	}

	public double withdrawMoney(double amount) {
		return this.balance -= amount;
	}

	public double getBalance() {
		return this.balance;
	}

	public void getAccountInfo() {
		String output = String.format("Account number: %d\nAccount owner: %s\nBalance: %.2f", this.accountNumber,
				this.accountOwner, getBalance());
		System.out.println(output);
	}

	public static void main(String args[]) {
		OOP_02_BankAccount account01 = new OOP_02_BankAccount(1, "Tho", 1000);
		account01.depositMoney(5000);
		account01.withdrawMoney(2000);
		System.out.println("Current balance: " + account01.getBalance());
		account01.getAccountInfo();
	}

}