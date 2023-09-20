import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<BankAccount> accountList = new ArrayList<BankAccount>();

    static void showAccounts() {
        for (int i = 0; i < accountList.size(); i++) {
            accountList.get(i).showStats();
        }
    }

    public static void main(String[] args) {

        accountList.add(new BankAccount(123, 23000, "Johan Johnsson",
                "johan@johnsson-net.se", 739350926));
        int defaultAccount = 0;
        boolean isRunning = true;
        while (isRunning) {
            Scanner input = new Scanner(System.in);
            System.out.println("\nTHE BANK" +
                    "\n1. Create an account" +
                    "\n2. Deposit" +
                    "\n3. Withdraw" +
                    "\n4. Show bank accounts" +
                    "\n5. Change account to manage"+
                    "\n6. Quit");
            System.out.print("Enter: "); String choice = input.nextLine();
            switch (choice) {
                case "1": {
                    System.out.print("Enter customer name: ");
                    String name = input.nextLine();
                    System.out.print("Enter customer email: ");
                    String email = input.nextLine();
                    System.out.print("Enter customer phone number: ");
                    int phone = input.nextInt(); input.nextLine();
                    System.out.print("Enter customer account number: ");
                    int account = input.nextInt(); input.nextLine();
                    System.out.print("Enter account balance: ");
                    double money = input.nextDouble(); input.nextLine();
                    accountList.add(new BankAccount(account, money, name, email, phone));
                    break;
                }
                case "2": {
                    System.out.print("Enter how much to deposit: ");
                    accountList.get(0).deposit(input.nextDouble());
                    break;
                }
                case "3": {
                    System.out.print("How much would you like to withdraw? ");
                    accountList.get(0).withdraw(input.nextDouble());
                    break;
                }
                case "4": {
                    showAccounts();
                    break;
                }
                case "5": {

                    break;
                }
                case "6": {
                    isRunning = false;
                    break;
                }
                default:
                    System.out.print("\nWrong menu choice. Try again...");
            }
        }

    }
}