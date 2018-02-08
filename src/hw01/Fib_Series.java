package hw01;

import java.util.Scanner;

public class Fib_Series {
	private static Scanner scanner;

	// Big O Notation T(n) = T(n-1) + T(n-2) + O(1)

	public static void main(String args[]) {

		// ask the user for input, then print Fibonacci series
		System.out
				.println("Enter number upto which Fibonacci series to print: ");
		scanner = new Scanner(System.in);
		int number = scanner.nextInt();

		System.out.println("Fibonacci series upto " + number + " numbers : ");
		for (int i = 1; i <= number; i++) {
			System.out.print(fibonacci(i) + " ");
		}

	}

	/**
	 * Java program for Fibonacci number using recursion. This program uses tail
	 * recursion to calculate Fibonacci number for a given number
	 * 
	 * @return Fibonacci number
	 */
	public static int fibonacci(int number) {
		if (number == 1) {
			return 1;
		}
		if (number == 2) {
			return 1;
		}

		return fibonacci(number - 1) + fibonacci(number - 2);
	}

}
