package javaBasic;

import java.util.Scanner;

public class String_Format {

	public static void main(String[] args) {
		// Write a program that takes input of a person's name, age, and height (in
		// meters) and prints out the information in a formatted string.

		Scanner sc = new Scanner(System.in);
		System.out.println("Name: ");
		String personName = sc.nextLine();
		System.out.println("Age: ");
		int personAge = sc.nextInt();
		System.out.println("Height: ");
		float personHeight = sc.nextFloat();

		System.out.printf("Name: %s\nAge: %d\nHeight: %.2f", personName, personAge, personHeight);

		sc.close();

	}

}
