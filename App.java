package com.ontariotechu.sofe3980U;

import org.joda.time.LocalTime;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
	/**
	 * Main program: The entry point of the program. The local time will be printed first,
	 * It will allow the user to input two binary numbers, then perform and display the
	 * results of OR, AND, and Multiply operations, along with their summation.
	 *
	 * @param args: not used
	 */
	public static void main(String[] args) 
	{
		// Print the current local time
		LocalTime currentTime = new LocalTime();
		System.out.println("The current local time is: " + currentTime);

		// Create a Scanner for user input
		Scanner scanner = new Scanner(System.in);

		// Prompt user to enter the first binary number
		System.out.print("Enter the first binary number: ");
		String input1 = scanner.nextLine();
		Binary binary1 = new Binary(input1);
		System.out.println("First binary number is: " + binary1.getValue());

		// Prompt user to enter the second binary number
		System.out.print("Enter the second binary number: ");
		String input2 = scanner.nextLine();
		Binary binary2 = new Binary(input2);
		System.out.println("Second binary number is: " + binary2.getValue());

		// Perform addition
		Binary sum = Binary.add(binary1, binary2);
		System.out.println("Their summation is: " + sum.getValue());

		// Perform bitwise OR
		Binary orResult = Binary.or(binary1, binary2);
		System.out.println("Result of OR operation: " + orResult.getValue());

		// Perform bitwise AND
		Binary andResult = Binary.and(binary1, binary2);
		System.out.println("Result of AND operation: " + andResult.getValue());

		// Perform multiplication
		Binary multiplyResult = Binary.multiply(binary1, binary2);
		System.out.println("Result of multiplication: " + multiplyResult.getValue());

		// Close the scanner
		scanner.close();
	}
}
