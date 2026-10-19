/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atmsystemm;
import java.util.Scanner;
/**
 *
 * @author loura
 */
public class AtmSystemm {
    static double balance = 5000;
    static final int correctPIN = 1234;
    static final double withdrawalLimit=2000;
    static void verifyPIN(int pin) throws InvalidPINException {
        if (pin != correctPIN) {
            throw new InvalidPINException("Invalid PIN!");
        }
    }

    static void withdraw(double amount)
            throws InsufficientBalanceException, InvalidAmountException, WithdrawalLimitException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                "Amount must be greater than zero!"
            );
        }
        if (amount > withdrawalLimit) {
            throw new WithdrawalLimitException(
                "Withdrawal limit exceeded! Maximum limit is Rs. 2000."
            );
}
        if (amount > balance) {
            throw new InsufficientBalanceException(
                "Insufficient balance!"
            );
        }

        balance -= amount;
        System.out.println("Withdrawal successful!");
    }

    static void deposit(double amount)
            throws InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException(
                "Invalid deposit amount!"
            );
        }

        balance += amount;
        System.out.println("Deposit successful!");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter your PIN: ");
            int pin = sc.nextInt();

            verifyPIN(pin);

            System.out.println("\n1. Balance Enquiry");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: Rs." + balance);
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    double w = sc.nextDouble();
                    withdraw(w);
                    System.out.println("Balance: Rs." + balance);
                    break;

                case 3:
                    System.out.print("Enter amount: ");
                    double d = sc.nextDouble();
                    deposit(d);
                    System.out.println("Balance: Rs." + balance);
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } catch (InvalidPINException |
                WithdrawalLimitException |
                 InsufficientBalanceException |
                 InvalidAmountException e) {

            System.out.println("Error: " + e.getMessage());

        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Please enter a valid number.");

        } finally {
            System.out.println("Thank you for using ATM!");
            sc.close();
        }
    }
}
