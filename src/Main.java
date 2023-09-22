import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Lista som nås över hela programmet som konton sparas i.
    static List<BankAccount> accountList = new ArrayList<BankAccount>();

    // Metod för att visa lista över konton som finns.
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

    // Metod för att mata in en siffra, sålla ut bokstäver och negativa tal.
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

        // Två fördefinerade konton.
        accountList.add(new BankAccount("Johan Johnsson", "johan@johnsson-net.se",
                739350926, "Swedbank", 2485886887L, 25000));
        accountList.add(new BankAccount("Sven-Berit Urbansdotter", "svenberit34@passagen.se",
                735085566, "Nordea", 4565461231L, 19000));

        int defaultAccount = 0; // Anger vilket konto som ska visas som aktiv i huvudmenyn.
        boolean isRunning = true;
        while (isRunning) {
            Scanner input = new Scanner(System.in);
            System.out.println("\n==============================================");
            System.out.println("THE BANK");
            if (accountList.isEmpty()) {
                System.out.println("Current active account: No accounts found!");
            }
            else {
                System.out.println("Current active account: " + (defaultAccount + 1)
                        + " \"" + accountList.get(defaultAccount).getCustomerName() + "\"");
            }

            System.out.println("\n1. Create an account" +
                               "\n2. Deposit" +
                               "\n3. Withdraw" +
                               "\n4. Transfer between accounts" +
                               "\n5. Show bank accounts" +
                               "\n6. Change account to manage" +
                               "\n7. Delete account" +
                               "\n8. Quit");
            System.out.print("Enter: "); String choice = input.nextLine();
            switch (choice) {
                // Skapa nytt bank konto.
                case "1": {
                    System.out.println("\n==============================================");
                    System.out.print("Enter customer name: ");
                    String name = input.nextLine();
                    System.out.print("Enter customer email: ");
                    String email = input.nextLine();
                    System.out.print("Enter customer phone number: ");
                    int phone = (int)inputNumber();
                    System.out.print("Enter customer bank: ");
                    String bank = input.nextLine();
                    System.out.print("Enter customer account number: ");
                    int account = (int)inputNumber();
                    System.out.print("Enter account balance: ");
                    double money = inputNumber();
                    accountList.add(new BankAccount(name, email, phone, bank, account, money));
                    System.out.print("Account created!\n" +
                                       "Do you want to set it to active? ");
                    while (true) {
                        String makeActive = input.nextLine();
                        if (makeActive.equalsIgnoreCase("yes")) {
                            defaultAccount = (accountList.size() - 1);
                            System.out.println("Changed active account...");
                            break;
                        }
                        else if (makeActive.equalsIgnoreCase("no")) {
                            System.out.println("Active account unchanged...");
                            break;
                        }
                        else {
                            System.out.print("Yes or no: ");
                        }
                    }

                    break;
                }
                // Sätt in pengar.
                case "2": {
                    if (!accountList.isEmpty()) {
                        System.out.println("\n==============================================");
                        System.out.print("Enter how much to deposit: ");
                        accountList.get(defaultAccount).deposit(inputNumber());
                    }
                    else {
                        System.out.println("No accounts found!");
                    }
                    break;
                }
                // Ta ut pengar.
                case "3": {
                    if (!accountList.isEmpty()) {
                        System.out.println("\n==============================================");
                        System.out.print("How much would you like to withdraw? ");
                        accountList.get(defaultAccount).withdraw(inputNumber());
                    }
                    else {
                        System.out.println("No accounts found!");
                    }
                    break;
                }
                // För över pengar mellan konton.
                case "4": {
                    System.out.println("\n==============================================");
                    showAccounts();
                    if (!accountList.isEmpty()) {
                        System.out.print("Enter what account number do you want to transfer from: ");
                        int fromAccount = ((int)inputNumber() -1);
                        System.out.print("Enter reciever account number: ");
                        int toAccount = ((int)inputNumber() -1);
                        System.out.println("Enter much money to transfer:");
                        double moneyTransfer = inputNumber();
                        // Om det finns tillräckligt med pengar.
                        if (moneyTransfer <= accountList.get(fromAccount).getAccountBalance()) {
                            accountList.get(toAccount).addToAccount(moneyTransfer);
                            accountList.get(fromAccount).removeFromAccount(moneyTransfer);
                            System.out.println(moneyTransfer + " kr was tranferred from "
                                    + accountList.get(fromAccount).getCustomerName()
                                    + " to " + accountList.get(toAccount).getCustomerName());
                        }
                        else {
                            System.out.println("There is not enough money...");
                        }
                        showAccounts();
                    }
                    else {
                        System.out.println("No accounts found!");
                    }
                    break;
                }
                // Visa konton.
                case "5": {
                    System.out.println("\n==============================================");
                    showAccounts();
                    break;
                }
                // Byt aktivt konto.
                case "6": {
                    System.out.println("\n==============================================");
                    showAccounts();
                    if (!accountList.isEmpty()) {
                        System.out.print("Change to account: ");
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
                    }
                    break;
                }
                // Ta bort ett konto.
                case "7": {
                    System.out.println("\n==============================================");
                    showAccounts();
                    if (!accountList.isEmpty()) {
                        System.out.print("Enter account to delete: ");
                        int del = ((int)inputNumber() - 1);
                        // Om konto du matat in finns.
                        if (del >= 0 && del < accountList.size()) {
                            System.out.print("Are you sure? (Yes or No): ");
                            String answer = input.nextLine();
                            if (answer.equalsIgnoreCase("yes")) {
                                System.out.println("Account #" + (del+1) + " " + accountList.get(del).getCustomerName()
                                        + " deleted!");
                                System.out.println("Active account has been reset.");
                                defaultAccount = 0;
                                accountList.remove(del);

                            }
                            else if (answer.equalsIgnoreCase("no")) {
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
                // Avsluta programmet.
                case "8": {
                    isRunning = false;
                    break;
                }
                default:
                    System.out.print("\nWrong menu choice. Try again...");
            }
        }

    }
}