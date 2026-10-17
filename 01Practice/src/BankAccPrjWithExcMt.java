//NegativeAmountException.java
class NegativeAmountException extends Exception{
	
	private static final long serialVersionUID=1L;
	
	public NegativeAmountException() {
		
	}
	public NegativeAmountException(String msg) {
		super(msg);
	}
	
}
//InsufficientFundsException.java
class InsufficientFundsException extends Exception{
	
	private static final long serialVersionUID=1L;
	
	public InsufficientFundsException() {
		
	}
	public InsufficientFundsException(String msg) {
		super(msg);
	}
}
//BankAccount.java
interface BankAccount{
	void deposit(double amt) throws NegativeAmountException;
	void withdraw(double amt) throws NegativeAmountException,InsufficientFundsException;
	void currentBalance();
}

class HdfcBankAccount implements BankAccount{
	
  private long accNum;
  private String accHName;
  private double balance;
  
  public HdfcBankAccount(long accNum, String accHName, double balance) {
	super();
	this.accNum = accNum;
	this.accHName = accHName;
	this.balance = balance;
  }

  @Override
  public void deposit(double amt) throws NegativeAmountException {
	
	  if(amt<=0)
		  throw new NegativeAmountException("amt can not be 0 or -ve value");
	  
	  this.balance = this.balance + amt;
	  
	  System.out.println(amt + " is deposited in account "+ accNum);
	
  }

  @Override
  public void withdraw(double amt) throws NegativeAmountException, InsufficientFundsException {
	
	  if(amt<=0)
		  throw new NegativeAmountException("amt can not be 0 or -ve value");
	  if(amt>balance)
		  throw new InsufficientFundsException("Insufficient Funds");
	
	  this.balance = this.balance - amt;
	  System.out.println(amt + " is withdrawn from the account "+ accNum +" "+ accHName);
  }

  @Override
  public void currentBalance() {
	 
	  System.out.println(accNum  +"current balance: "+ balance);
	
  }
  
}
class DepositorThread extends Thread{
	
	private BankAccount acc;
	private double amt;
	
	public DepositorThread(BankAccount acc,double amt) {
		this.acc = acc;
		this.amt = amt;	
	}
	
	@Override
	public void run(){
		try {
			acc.deposit(amt);
		}catch(NegativeAmountException e) {
			System.out.println(e.getMessage());
		}
	}
}
class WithdraweeThread extends Thread{
	
	private BankAccount acc;
	private double amt;
	
	public WithdraweeThread(BankAccount acc,double amt) {
		this.acc = acc;
		this.amt = amt;	
	}
	
	@Override
	public void run(){
		try {
			acc.withdraw(amt);
		}catch(NegativeAmountException | InsufficientFundsException e) {
			System.out.println(e.getMessage());
		}
	}
}
public class BankAccPrjWithExcMt{
	
	public static void main(String[] args) throws InterruptedException {
		
		HdfcBankAccount acc1 = new HdfcBankAccount(1234, "HK", 10000);
		HdfcBankAccount acc2 = new HdfcBankAccount(5674, "HK", 20000);
		HdfcBankAccount acc3 = new HdfcBankAccount(8784, "HK", 30000);
		
		acc1.currentBalance();
		acc2.currentBalance();
		acc3.currentBalance();
		System.out.println();
		
		DepositorThread  dt1 = new DepositorThread(acc1, 5000);
		DepositorThread  dt2 = new DepositorThread(acc2, 2000);
		DepositorThread  dt3 = new DepositorThread(acc3, 3000);
		
		dt1.start();
		dt2.start();
		dt3.start();
		
		Thread.sleep(5000);//pausing main thread for 5 seconds
		System.out.println();
		
		acc1.currentBalance();
		acc2.currentBalance();
		acc3.currentBalance();
	}
}
