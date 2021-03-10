package BankAccount;

public class UserBankAccountTest {

	public static void main(String[] args) {
		UserBankAccount account1 = new UserBankAccount();

		System.out.println("Here is your account number : " + account1.newaccNum());
        account1.getCheckings();
        account1.getSavings();
        account1.DepositSavings(250);
        account1.DepositCheckings(500);
        account1.withdrawalcheckings(100);
        System.out.println(account1.getCheckings());
        account1.withdrawalsavings(75);
        System.out.println(account1.getSavings());
        account1.sum();
        System.out.println("Here it the total balance for accounts : $" + account1.sum());
	}

}
