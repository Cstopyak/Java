package BankAccount;

import java.util.Random;

public class UserBankAccount {

	static int numOfAccounts;
	static double totalAmountofMoney;

	protected String accountnumber = "";
	protected double checkings = 0;
	protected double savings = 0;

	public UserBankAccount() {
		
		numOfAccounts += 1;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public double getCheckings() {
		return checkings;
	}

	public void setCheckings(double checkings) {
		this.checkings = checkings;
	}

	public double getSavings() {
		return savings;
	}

	public void setSavings(double savings) {
		this.savings = savings;
	}

	public String newaccNum() {
		Random randnum = new Random();
		String numbers = "0,1,2,3,4,5,6,7,8,9";
		String randomNum = "";

		for (int x = 0; x < 5; x++) {
			int num = numbers.charAt(randnum.nextInt(10));
			randomNum += num;
		}
		accountnumber = randomNum;
		return randomNum;
	}

	public void DepositCheckings(int i) {
		this.setCheckings(i);
		totalAmountofMoney += i;
	}

	public void DepositSavings(int i) {
		this.setCheckings(i);
		totalAmountofMoney += i;
	}

	public double sum() {
		totalAmountofMoney = checkings + savings;
		return totalAmountofMoney;
	}

	public void withdrawalcheckings(int amount) {
		if (getCheckings() < Double.valueOf(amount)) {
			System.out.println("Insufficient funds in checkings...");
		} else {
			this.setCheckings(getCheckings() - Double.valueOf(amount));
		}
	}

	public void withdrawalsavings(int amount) {
		if (getSavings() < Double.valueOf(amount)) {
			System.out.println("Insufficient funds in savings...");
		} else {
			this.setSavings(getSavings() - Double.valueOf(amount));
		}
	}
}