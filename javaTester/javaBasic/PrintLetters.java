package javaBasic;

import java.util.Scanner;

public class PrintLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Prompt the user to enter a letter to search for
        System.out.print("Enter a letter: ");
        char letter = scanner.next().charAt(0);

        // Find the position of the letter in the alphabet (case-insensitive)
        int position = Character.toLowerCase(letter) - 'a';

        // Print all letters that come after the user-specified letter in the alphabet
        System.out.print("Letters that come after '" + letter + "' in the alphabet: ");
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (Character.toLowerCase(c) >= letter && Character.toLowerCase(c) - 'a' != position) {
                System.out.print(c + " ");
            }
        }
    }
}
