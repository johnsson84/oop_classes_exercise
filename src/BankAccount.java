public class BankAccount {

    private int accountNumber;
    private double accountBalance;
    private String customerName;
    private String customerEmail;
    private int customerPhone;

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
    }

    public double withdraw(double money) {
        if (money > this.accountBalance) {
            this.accountBalance -= money;
        }
        else {
            System.out.println("You don't have enough money...");
            money = 0;
        }
        return money;
    }
}
