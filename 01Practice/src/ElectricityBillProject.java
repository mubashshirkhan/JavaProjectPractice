// Custom Exception 1
class InvalidPaymentException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidPaymentException() {
        super();
    }

    public InvalidPaymentException(String msg) {
        super(msg);
    }
}

// Custom Exception 2
class InsufficientBalanceException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientBalanceException() {
        super();
    }

    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}

// Interface
interface ElectricityAccount {

    void recharge(double amount) throws InvalidPaymentException;

    void payBill(double amount)
            throws InvalidPaymentException, InsufficientBalanceException;

    void checkBalance();
}

// Implementation Class
class CustomerElectricityAccount implements ElectricityAccount {

    private long customerId;
    private String customerName;
    private double balance;

    // Parameterized Constructor
    public CustomerElectricityAccount(long customerId,
                                      String customerName,
                                      double balance) {

        this.customerId = customerId;
        this.customerName = customerName;
        this.balance = balance;
    }

    // Recharge Method
    @Override
    public synchronized void recharge(double amount)
            throws InvalidPaymentException {

        if (amount <= 0) {
            throw new InvalidPaymentException(
                    "Amount cannot be zero or negative");
        }

        this.balance = this.balance + amount;

        System.out.println(
                customerName + " recharged Rs." + amount
                + " successfully");
    }

    // Bill Payment Method
    @Override
    public synchronized void payBill(double amount)
            throws InvalidPaymentException, InsufficientBalanceException {

        if (amount <= 0) {
            throw new InvalidPaymentException(
                    "Amount cannot be zero or negative");
        }

        if (amount > balance) {
            throw new InsufficientBalanceException(
                    customerName + " has insufficient balance");
        }

        this.balance = this.balance - amount;

        System.out.println(
                customerName + " paid bill of Rs." + amount
                + " successfully");
    }

    // Check Balance Method
    @Override
    public synchronized void checkBalance() {

        System.out.println(
                "Customer ID: " + customerId
                + " | Name: " + customerName
                + " | Balance: Rs." + balance);
    }
}

// Recharge Thread
class RechargeThread extends Thread {

    private ElectricityAccount acc;
    private double amount;

    public RechargeThread(ElectricityAccount acc, double amount) {
        this.acc = acc;
        this.amount = amount;
    }

    @Override
    public void run() {

        try {
            acc.recharge(amount);
        }
        catch (InvalidPaymentException e) {
            System.out.println(e.getMessage());
        }
    }
}

// Bill Payment Thread
class BillPaymentThread extends Thread {

    private ElectricityAccount acc;
    private double amount;

    public BillPaymentThread(ElectricityAccount acc, double amount) {
        this.acc = acc;
        this.amount = amount;
    }

    @Override
    public void run() {

        try {
            acc.payBill(amount);
        }
        catch (InvalidPaymentException | InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }
}

// Main Class
public class ElectricityBillProject {

    public static void main(String[] args)
            throws InterruptedException {

        // Creating Customer Accounts
        CustomerElectricityAccount acc1 =
                new CustomerElectricityAccount(4001L, "HK", 2000);

        CustomerElectricityAccount acc2 =
                new CustomerElectricityAccount(2001L, "SH", 3000);

        CustomerElectricityAccount acc3 =
                new CustomerElectricityAccount(3001L, "SD", 4000);

        // Initial Balances
        System.out.println("===== INITIAL BALANCES =====");

        acc1.checkBalance();
        acc2.checkBalance();
        acc3.checkBalance();

        // Creating Recharge Threads
        RechargeThread rch1 = new RechargeThread(acc1, 2000);
        RechargeThread rch2 = new RechargeThread(acc2, 1500);
        RechargeThread rch3 = new RechargeThread(acc3, 3000);

        // Starting Recharge Threads
        rch1.start();
        rch2.start();
        rch3.start();

        // Waiting for Recharge Threads
        rch1.join();
        rch2.join();
        rch3.join();

        System.out.println("\n===== AFTER RECHARGE =====");

        acc1.checkBalance();
        acc2.checkBalance();
        acc3.checkBalance();

        // Creating Bill Payment Threads
        BillPaymentThread bp1 = new BillPaymentThread(acc1, 1000);
        BillPaymentThread bp2 = new BillPaymentThread(acc2, 10000);

        // Starting Bill Payment Threads
        bp1.start();
        bp2.start();

        // Waiting for Bill Payment Threads
        bp1.join();
        bp2.join();

        System.out.println("\n===== FINAL BALANCES =====");

        acc1.checkBalance();
        acc2.checkBalance();
        acc3.checkBalance();
    }
}