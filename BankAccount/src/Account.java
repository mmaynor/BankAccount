import java.util.Scanner;

public class Account {
	String MemberName;
	String AccountId;
	double balance;
	double previousTransaction;
	
	public Account(String mName, String aId) {
		String MemberName = mName;
		String AccountId = aId;
	}
	void deposit(double amount) {
		if(amount != 0) {
			balance = amount + balance;
			previousTransaction = amount;
		}
	}
	void withdraw(double amount) {
		if(amount != 0) {
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}
	void previousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("Amount deposited is " + previousTransaction);
		}
		else if (previousTransaction < 0) {
			System.out.println("Amount withdrawn is " + Math.abs(previousTransaction));
		}
		else
			System.out.println("No previousTransaction made");
	}
	void getInterest(int year) {
		double interest = .10;
		double updatedBalance = (interest * balance * year) + balance;
		System.out.println("Inerest rate is " + (interest * 100));
		System.out.println("Amount of interest for " + year + "(s) is " + updatedBalance);
	}
	void menu() {
		char option = '\0';
		Scanner scan = new Scanner(System.in);
		System.out.println("Hello " + MemberName + ". Your account number is " + AccountId);
		System.out.println();
		System.out.println("List of account transaction options");
		System.out.println();
		System.out.println("A. Check balance of account");
		System.out.println("B. Deposit money into account");
		System.out.println("C. Withdraw money from account");
		System.out.println("D. Check previousTransaction that was done");
		System.out.println("E. Calculate interest for years that are entered");
		System.out.println("F. Quit");
		
		do {
			System.out.println("Enter an option");
			char option1 = scan.next().charAt(0);
			option = Character.toUpperCase(option1);
			System.out.println();
			
			switch(option) {
			case 'A':
				System.out.println("*********************************");
				System.out.println("Balance total is $" + balance);
				System.out.println("*********************************");
				System.out.println();
				break;
			case 'B':
				System.out.println("Enter amount to deposit");
				double deposit = scan.nextInt();
				deposit(deposit);
				System.out.println();
				break;
			case 'C':
				System.out.println("Enter withdrawal amount");
				double withdraw = scan.nextInt();
				withdraw(withdraw);
				System.out.println();
				break;
			case 'D':
				System.out.println("*********************************");
				previousTransaction();
				System.out.println("*********************************");
				System.out.println();
				break;
			case 'E':
				System.out.println("Enter number of year(s)");
				int year = scan.nextInt();
				getInterest(year);
				System.out.println();
				break;
			case 'F':
				break;
			default:
				System.out.println("Please enter a vaild option. Either A, B, C, D, E, or F.");
				break;
			}
		} 
		while(option != 'F');
		System.out.println("Thanks for using BankAccount");
	}
}
