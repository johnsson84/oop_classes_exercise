import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<BankAccount> accountList = new ArrayList<BankAccount>();

    static void showAccounts() {
        if (accountList.isEmpty()) {
            System.out.println("List is empty...");
        }
        else {
            for (int i = 0; i < accountList.size(); i++) {
                System.out.print((i+1) + ". ");  accountList.get(i).showStats();
            }
        }
    }

    static double inputNumber() {
        Scanner in = new Scanner(System.in);
        double input = 0;
        while (true) {
            try {
                double nr = in.nextDouble();
                if (nr >= 0) {
                    input = nr;
                    break;
                }
                else {
                    System.out.print("Cant be negative, try again: ");
                }
            }
            catch (InputMismatchException e) {
                System.out.print("Cant be a letter, try again: ");
                in.nextLine();
            }
        }
        return input;
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
                    "\n5. Change account to manage" +
                    "\n6. Delete account" +
                    "\n7. Quit");
            System.out.print("Enter: "); String choice = input.nextLine();
            switch (choice) {
                case "1": {
                    System.out.println("\n==============================================");
                    System.out.print("Enter customer name: ");
                    String name = input.nextLine();
                    System.out.print("Enter customer email: ");
                    String email = input.nextLine();
                    System.out.print("Enter customer phone number: ");
                    int phone = (int)inputNumber();
                    System.out.print("Enter customer account number: ");
                    int account = (int)inputNumber();
                    System.out.print("Enter account balance: ");
                    double money = inputNumber();
                    accountList.add(new BankAccount(account, money, name, email, phone));
                    break;
                }
                case "2": {
                    System.out.println("\n==============================================");
                    System.out.print("Enter how much to deposit: ");
                    accountList.get(defaultAccount).deposit(inputNumber());
                    break;
                }
                case "3": {
                    System.out.println("\n==============================================");
                    System.out.print("How much would you like to withdraw? ");
                    accountList.get(defaultAccount).withdraw(inputNumber());
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
                    int nr = ((int)inputNumber() - 1);
                    if (nr >= 0 && nr < accountList.size()) {
                        System.out.println("Change account from #" + (defaultAccount + 1) + " "
                                + accountList.get(defaultAccount).getCustomerName() + " to #" + (nr + 1) + " "
                                + accountList.get(nr).getCustomerName());
                        defaultAccount = nr;
                    }
                    else {
                        System.out.println("Wrong input or account does not exist!");
                    }
                    break;
                }
                case "6": {
                    System.out.println("\n==============================================");
                    showAccounts();
                    if (!accountList.isEmpty()) {
                        System.out.print("Enter account to delete: ");
                        int del = ((int)inputNumber() - 1);
                        if (del >= 0 && del < accountList.size()) {
                            System.out.print("Are you sure? (Yes or No): ");
                            String answer = input.nextLine();
                            if (answer.toLowerCase().equals("yes")) {
                                System.out.println("Account #" + (del+1) + " " + accountList.get(del).getCustomerName()
                                        + " deleted!");
                                accountList.remove(del);
                            }
                            else if (answer.toLowerCase().equals("no")) {
                                System.out.println("No accounts deleted.");
                            }
                            else {
                                System.out.println("Wrong input, returns to menu...");
                            }
                        }
                        else {
                            System.out.println("Wrong input or account does not exist!");
                        }
                    }
                    break;
                }
                case "7": {
                    isRunning = false;
                    break;
                }
                default:
                    System.out.print("\nWrong menu choice. Try again...");
            }
        }

    }
}