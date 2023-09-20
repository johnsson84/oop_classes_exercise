public class BankAccount {

    private int accountNumber;
    private double accountBalance;
    private String customerName;
    private String customerEmail;
    private int customerPhone;

    public BankAccount(int accountNumber, double accountBalance, String customerName, String customerEmail, int customerPhone) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    public double getAccountBalance() {
        return accountBalance;
    }
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(int customerPhone) {
        this.customerPhone = customerPhone;
    }

    public void deposit(double money) {
        this.accountBalance += money;
        System.out.println("You have " + this.accountBalance + " kr on your account.");
    }

    public double withdraw(double money) {
        if (money < this.accountBalance) {
            this.accountBalance -= money;
            System.out.println("You have " + this.accountBalance + " kr after withdrawal.");
        }
        else {
            System.out.println("You don't have enough money...");
            money = 0;
        }
        return money;
    }

    public void showStats() {
        System.out.println("Name: " + customerName +
                           " | Email: " + customerEmail +
                           " | Phonenumber: " + customerPhone +
                           " | Account number: " + accountNumber +
                           " | Account balance: " + accountBalance);
    }

    public void addToAccount(double addMoney) {
        this.accountBalance += addMoney;
    }
    public void removeFromAccount(double removeMoney) {
        this.accountBalance -= removeMoney;
    }
}
