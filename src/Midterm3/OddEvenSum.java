package Midterm3;

/**
 * Work Reference from:
 * https://www.chegg.com/homework-help/questions-and-answers
 * /java-write-program-determine
 * -effects-path-compression-various-unioning-strategies-program--q9410013
 * 
 * Sum the odd numbers and the even numbers from a lower bound to an upper bound
 */
public class OddEvenSum {
	public static void main(String[] args) {
		int lowerbound = 1, upperbound = 1000;
		int sumOdd = 0; // For accumulating odd numbers, initialization to 0
		int sumEven = 0; // For accumulating even numbers, initialization to 0
		int number = lowerbound;
		while (number <= upperbound) {
			if (number % 2 == 0) { // Even
				sumEven += number; // Same as sumEven = sumEven + number
			} else { // Odd
				sumOdd += number; // Same as sumOdd = sumOdd + number
			}
			++number; // Next number
		}
		// Print the result
		System.out.println("The sum of odd numbers from " + lowerbound + " to "
				+ upperbound + " is " + sumOdd);
		System.out.println("The sum of even numbers from " + lowerbound
				+ " to " + upperbound + "  is " + sumEven);
		System.out.println("The difference between the two sums is "
				+ (sumOdd - sumEven));
	}
}