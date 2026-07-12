package ui;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InputUtils {

    public static int getInt(Scanner input, String msg) {
        while (true) {
            System.out.print(msg);
            if (input.hasNextInt()) {
                int value = input.nextInt();
                input.nextLine();
                return value;
            } else {
                input.next();
                System.out.println("Invalid number, try again.");
            }
        }
    }

    public static double getDouble(Scanner input, String msg) {
        while (true) {
            System.out.print(msg);
            if (input.hasNextDouble()) {
                double value = input.nextDouble();
                input.nextLine();
                return value;
            } else {
                input.next();
                System.out.println("Invalid number, try again.");
            }
        }
    }

    public static String getString(Scanner input, String msg) {
        System.out.print(msg);
        return input.nextLine().trim().toLowerCase();
    }

    public static LocalDate getDate(Scanner input, String msg) {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            System.out.print(msg);
            String dateText = input.nextLine();

            try {
                return LocalDate.parse(dateText, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date. Try again.");
            }
        }
    }
}