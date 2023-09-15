
package ass2;
import java.util.*;
//-----------------------------------------------------
		// Written by: Maha Ali AL-Zboon
		//Financial System
//----------------------------------------------------- 


class BankAccount {//BankAccount
			private double balance;//instance field balance
			Scanner keyboard=new Scanner(System.in);
			BankAccount() {//default constructor
			    this.balance = 0;
			}
			
			
			public BankAccount(double amount) {// Parameterized constructor
			    this.balance = amount;
			}
			
			public void deposit(double amount) {//deposit method that takes in amount to be deposited
				balance += amount;
				System.out.println(amount+" deposited ");
				System.out.println("Balance after deposit: "+ balance);
			    
			}
			public void withdraw(double amount) {// This method will takes amount to withdraw
			    if (balance >= amount) {
			    	balance -=amount;
			    	System.out.println(amount+ " withdrawn ");
			        System.out.println("Balance after withdrawal: "+balance);
			    }
			    else {
			    	System.out.println("amount of mony you want to withdraw is more than your balance");
			    	System.out.println("please enter a new amount to withdraw: ");
			    	amount=keyboard.nextDouble();
			    	withdraw(amount);
			    }
			}
			
			
			
			public double getBalance() {// return the current balance in the account.
			    return balance;
			}
			
			public void transferMoney(double amount, BankAccount toBankAccount) {// transfers money from this bank account to other bank account
			
			    if (amount <= balance) {
			        toBankAccount.deposit(amount);
			        balance -= amount;
			        System.out.println(amount+"had been transfered");
			    }
			    else {
			    	System.out.println("amount of mony you want to transfer is more than your balance");
			    	System.out.println("please enter a new amount to transfer: ");
			    	amount=keyboard.nextDouble();
			    	transferMoney(amount,toBankAccount);
			    	
			    	
			    }
			
			}
			
			public void display() {
			    System.out.println("Balance : " + balance+"$");
			}
	}// end of BankAccount class
//--------------------------------------------------------------------
//CheckingAccount
class CheckingAccount extends BankAccount {

			final double ALLOWED_TRANS = 2;
			final double TRANS_FEE = 3;
			private int transCnt;
			public CheckingAccount() {//Constructor to create zero balance account.
			    transCnt = 0;
				}  
			public CheckingAccount(double balance) {//Parameterized Constructor to create an account with an initial balance

			    super(balance);
			    transCnt = 0;
				}
			
			public void deposit(double amount) {//override
				  
		        super.deposit(amount);
		        transCnt++;//increment transactions by one
		   
				}
			
			
			public void withdraw(double amount) {//override
			
			    super.withdraw(amount);
			    transCnt++;//increment transactions by one
				}
			
			
			public void chargeFees()
				{
				    if(transCnt>2)
				    {
				        super.withdraw((transCnt-ALLOWED_TRANS)*3);
				    }
				}
	}//end of CheckingAccount class

//---------------------------------------------------------------------
//SavingsAccount
class SavingsAccount extends BankAccount {
	
			private double interestRate;
			
			public SavingsAccount(double interestRate) {//sets interest rate
			    this.interestRate = interestRate;
				}
			
			public SavingsAccount(double balance, double interestRate) {//sets interest rate and initial balance.
			    super(balance);
			    this.interestRate = interestRate;
			}
			
			public void addCompoundInterest()
			{
			    double interest = ( getBalance() * interestRate / 100.0 );//calculate the interest
			    deposit(interest);//Deposit the interest to the account
			}
	}//end of SavingsAccount
//---------------------------------------------------------------
//TransactionsDriver class that include main method 
public class class1 {

	public static void main(String[] args) {
		 System.out.println("Hello, i'm MAHA\n");

		 
		 SavingsAccount dadsSaving=new SavingsAccount(0.3);//object from class SavingsAccount
	     CheckingAccount kidsChecking=new CheckingAccount();//object from class CheckingAccount
	     
	     //some transactions
	     dadsSaving.deposit(10000);
	     dadsSaving.transferMoney(3000,kidsChecking);
	     kidsChecking.withdraw(200);
	     kidsChecking.withdraw(400);
	     kidsChecking.withdraw(300);
	     kidsChecking.withdraw(500);
	     kidsChecking.withdraw(400);
	     dadsSaving.addCompoundInterest();
	     kidsChecking.chargeFees();
	     
	     System.out.println("\nBalance in Dad's savings Account :"+dadsSaving.getBalance());
	     System.out.println("Balance in Kid's checking Account :"+kidsChecking.getBalance()+"\n\n");
	     
	     
	     //----------------<3
		 System.out.println("The program is ended");//closing message 

	}

}

