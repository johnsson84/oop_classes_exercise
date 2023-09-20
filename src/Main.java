import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean isRunning = true;
        while (isRunning) {
            Scanner input = new Scanner(System.in);
            System.out.println("\nTHE BANK" +
                    "\n1. Create an account" +
                    "\n2. Deposit" +
                    "\n3. Withdraw" +
                    "\n4. Quit");
            System.out.print("Enter: "); String choice = input.nextLine();
            switch (choice) {
                case "1": {
                    break;
                }
                case "2": {
                    break;
                }
                case "3": {
                    break;
                }
                case "4": {
                    isRunning = false;
                    break;
                }
                default:
                    System.out.print("\nWrong menu choice. Try again...");
            }
        }

    }
}