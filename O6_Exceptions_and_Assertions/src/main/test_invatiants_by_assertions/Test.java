package main.test_invatiants_by_assertions;

/*
 * In Java, assertions are a tool used to check that certain conditions hold
 * true during runtime, mainly for debugging and testing invariants. An
 * invariant is a condition or assumption about the state of your program that
 * must always be true at a specific point in the code.
 * 
 * Assertions in Java can be enabled or disabled at runtime using the -ea
 * (enable assertions) or -da (disable assertions) flags when running the
 * program. By default, assertions are disabled.
 */
public class Test {

	public static void main(String[] args) {

		// Test creating a BankAccount with valid and invalid initial balance
		BankAccount account = new BankAccount(100); // Valid initial balance

		// Uncomment the next line to see the assertion error for invalid initial
		// balance
		//BankAccount account = new BankAccount(-50); // This will fail

		// Test deposit with a valid amount
		account.deposit(50); // Balance should now be 150

		// Uncomment to test assertion on deposit with negative amount
		//account.deposit(-20); // This will fail with assertion error

		// Test withdraw with valid amount
		account.withdraw(50); // Balance should now be 100

		// Uncomment to test assertion on withdrawal that would make balance negative
		//account.withdraw(200); // This will fail with assertion error

		// Check final balance
		System.out.println("Final balance: " + account.getBalance());
	}

}

class BankAccount {
	private double balance;

	public BankAccount(double initialBalance) {
		assert initialBalance >= 0 : "Initial balance cannot be negative"; // Invariant check
		this.balance = initialBalance;
	}

	public void deposit(double amount) {
		assert amount > 0 : "Deposit amount must be positive"; // Check precondition
		balance += amount;
	}

	public void withdraw(double amount) {
		assert amount > 0 : "Withdrawal amount must be positive"; // Check precondition
		assert balance - amount >= 0 : "Balance cannot go negative"; // Invariant check
		balance -= amount;
	}

	public double getBalance() {
		return balance;
	}
}
