package ge.temo;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int principal;
        while (true) {
            System.out.print("Principal ($1K-$1M): ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a value between 1,000 and 1,000,000");
        }

        float monthlyInterest = 0;
        while (true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterest = scanner.nextFloat();
            if (annualInterest > 0 && annualInterest <= 30)
                break;
            System.out.println("Enter a value between 1 and 30");
            monthlyInterest = annualInterest / 100 / 12;
        }

        int numOfPayments = 0;
        while (true) {
            System.out.print("Period: ");
            byte years = scanner.nextByte();
            if (years > 0 && years <= 12)
                break;
            System.out.println("Enter a value between 1 and 12");
            numOfPayments = years * 12;
        }

        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numOfPayments)) / (Math.pow(1 + monthlyInterest, numOfPayments) - 1);
        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}