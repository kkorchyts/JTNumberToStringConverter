package com.kkorchyts.jtnumbertostringconverter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Converter {
    private static Map<Integer, String> units = new HashMap<>();
    private static Map<Integer, String> dozens = new HashMap<>();
    private static Map<Integer, String> hundreds = new HashMap<>();


    private static int[] getDigits(int number) {
        int[] result = new int[String.valueOf(Math.abs(number)).length()];

        int counter = 0;
        while (number > 0) {
            result[counter++] = number % 10;
            number = number / 10;
        }

        return result;
    }

    private static void showArray(int[] array) {
        showArray(array, "There is entered array:");
    }

    private static void showArray(int[] array, String message) {
        showArray(array, message, false, false);
    }

    private static void showArray(int[] array, String message, boolean onlyElements, boolean inOneLine) {
        System.out.print(message);
        String format = onlyElements ? "| %2$3d " : "| array[%3d]=%5d ";
        if (!inOneLine) {
            System.out.println();
            format += "\n";
        }

        for (int i = 0; i < array.length; i++) {
            System.out.printf(format, i, array[i]);
        }
        if (inOneLine) {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {

            System.out.println("Введите положительное целое число для конвертации. -1 для выхода :");
            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                System.out.println("Hey boy, enter only numbers, please!");
                continue;
            }

            number = scanner.nextInt();
            if (number == -1){
                break;
            }
            if (number < -1) {
                System.out.println("Hey boy, enter only positive numbers, please!");
                continue;
            }
            convert(number);
        } while (true);
    }

    static void convert(int number) {
        int[] digits = getDigits(number);
        showArray(digits, "Array of digits: ", true, true);
        ArrayList<String> lexems = new ArrayList<>();

        int startPos = 0;
        if (digits.length > 2 && digits[1] == 1) {
            lexems.add(units.get(digits[1]*10 + digits[0]));
            startPos = 2;
        }

        while (startPos < digits.length) {
            int key = (int) (digits[startPos] * Math.pow(10, startPos++));
            if (key
            lexems.add(units.get(key));
        }

        System.out.println("Result: ");
        for (int i = lexems.size() - 1; i >=0 ; i--) {
            System.out.print(lexems.get(i) + " ");
        }
    }

    static {
        units.put(0, "ноль");
        units.put(1, "один");
        units.put(2, "два");
        units.put(3, "три");
        units.put(4, "четрые");
        units.put(5, "пять");
        units.put(6, "шесть");
        units.put(7, "семь");
        units.put(8, "восемь");
        units.put(9, "девять");
        units.put(10, "десять");
        units.put(11, "одиннадцать");
        units.put(12, "двенадцать");
        units.put(13, "тринадцать");
        units.put(14, "четырнадцать");
        units.put(15, "пятнадцать");
        units.put(16, "шестнадцать");
        units.put(17, "семнадцать");
        units.put(18, "восемнадцать");
        units.put(19, "девятнадцать");

        units.put(20, "двадцать");
        units.put(30, "тридцать");
        units.put(40, "сорок");
        units.put(50, "пятьдесят");
        units.put(60, "шестьдесят");
        units.put(70, "семьдесят");
        units.put(80, "восемьдесят");
        units.put(90, "девяносто");

        units.put(100, "сто");
        units.put(200, "двести");
        units.put(300, "триста");
        units.put(400, "четыреста");
        units.put(500, "пятьсот");
        units.put(600, "шестьсот");
        units.put(700, "семьсот");
        units.put(800, "восемьсот");
        units.put(900, "девятьсот");
    }
}
