public class BankAccount {
    private String customerName;
    private String customerEmail;
    private int customerPhone;
    private String bank;
    private long accountNumber;
    private double accountBalance;

    public BankAccount(String customerName, String customerEmail, int customerPhone, String bank, long accountNumber, double accountBalance) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(long accountNumber) {
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
    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
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
        System.out.printf("|%-11s %30s| |%-11s %30s| |%-11s %30s|\n   |%-11s %30s| |%-11s %30s| |%-11s %30s|\n",
                "Name:", customerName,
                "Email:", customerEmail,
                "Phone:", "0" + customerPhone,
                "Bank:", bank,
                "Account nr:", accountNumber,
                "Balance:", accountBalance + " SEK");
        System.out.println("==============================================");
        /*
        System.out.println("Name: " + customerName +
                           " | Email: " + customerEmail +
                           " | Phonenumber: " + customerPhone +
                           " | Account number: " + accountNumber +
                           " | Account balance: " + accountBalance);

         */
    }

    public void addToAccount(double addMoney) {
        this.accountBalance += addMoney;
    }
    public void removeFromAccount(double removeMoney) {
        this.accountBalance -= removeMoney;
    }


}
