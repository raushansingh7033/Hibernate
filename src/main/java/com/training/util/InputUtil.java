package com.training.util;

import java.time.LocalDate;
import java.util.Scanner;

public class InputUtil {
    private static Scanner sc = new Scanner(System.in);

    public static String readString(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }

    public static int readInt(String msg) {
        System.out.print(msg);
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input! " + msg);
            sc.next();
        }
        int value = sc.nextInt();
        sc.nextLine(); // consume \n
        return value;
    }

    public static double readDouble(String msg) {
        System.out.print(msg);
        while (!sc.hasNextDouble()) {
            System.out.print("Invalid input! " + msg);
            sc.next();
        }
        double value = sc.nextDouble();
        sc.nextLine(); // consume \n
        return value;
    }

    public static LocalDate readDate(String msg) {
        System.out.print(msg);
        return LocalDate.parse(sc.nextLine());
    }

    public static char readChar(String msg) {
        System.out.print(msg);
        return sc.nextLine().charAt(0);
    }

    public static long readLong(String msg) {
        System.out.print(msg);
        while (!sc.hasNextLong()) {
            System.out.print("Invalid input! " + msg);
            sc.next();
        }
        long value = sc.nextLong();
        sc.nextLine();
        return value;
    }
}
