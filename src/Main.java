import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<BankAccount> accountList = new ArrayList<BankAccount>();

    static void showAccounts() {
        for (int i = 0; i < accountList.size(); i++) {
            System.out.print((i+1) + ". ");  accountList.get(i).showStats();
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
                    "\nCurrent active account: " + (defaultAccount + 1) + "\n" +
                    "\n1. Create an account" +
                    "\n2. Deposit" +
                    "\n3. Withdraw" +
                    "\n4. Show bank accounts" +
                    "\n5. Change account to manage"+
                    "\n6. Quit");
            System.out.print("Enter: "); String choice = input.nextLine();
            switch (choice) {
                case "1": {
                    System.out.println("\n==============================================");
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
                    System.out.println("\n==============================================");
                    System.out.print("Enter how much to deposit: ");
                    accountList.get(0).deposit(input.nextDouble());
                    break;
                }
                case "3": {
                    System.out.println("\n==============================================");
                    System.out.print("How much would you like to withdraw? ");
                    accountList.get(0).withdraw(input.nextDouble());
                    break;
                }
                case "4": {
                    System.out.println("\n==============================================");
                    showAccounts();
                    break;
                }
                case "5": {
                    System.out.println("\n==============================================");
                    showAccounts();
                    System.out.print("Enter an account from the list: ");
                    int nr = (input.nextInt() - 1);
                    if (nr >= 0 && nr < accountList.size()) {
                        System.out.println("Change account from " + (defaultAccount + 1) + " "
                                + accountList.get(defaultAccount).getCustomerName() + " to " + (nr + 1) + " "
                                + accountList.get(nr).getCustomerName());
                        defaultAccount = nr;
                    }
                    else {
                        System.out.println("Wrong input or account does not exist!");
                    }
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