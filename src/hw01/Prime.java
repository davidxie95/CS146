package hw01;

//problem 2.20
public class Prime {

	public static void main(String[] args) {

		int prime = 2;
		int prime2 = 7;
		int notPrime = 4;
		int notPrime2 = 25;
		
		System.out.println("Expected: true");
		System.out.println("Actual: " + isPrime(prime));
		System.out.println("Expected: true");
		System.out.println("Actual: " + isPrime(prime2));
		System.out.println("Expected: false");
		System.out.println("Actual: " + isPrime(notPrime));
		System.out.println("Expected: false");
		System.out.println("Actual: " + isPrime(notPrime2));

		System.out.println("Expected: 1");
		System.out.println("Actual: " + isPrime2(prime, prime-1));
		System.out.println("Expected: 1");
		System.out.println("Actual: " + isPrime2(prime2, prime2-1));
		System.out.println("Expected: 0");
		System.out.println("Actual: " + isPrime2(notPrime, notPrime-1));
		System.out.println("Expected: 0");
		System.out.println("Actual: " + isPrime2(notPrime2, notPrime2-1));
	}

	/**
	 * Write a program to determine if a positive integer, N, is prime.
	 * 
	 * @param n
	 *            the number to be checked if prime
	 * @return true if prime, else false
	 */
	public static boolean isPrime(int n) {

		if (n == 2)
			return true;
		// check if n is divisible by 2
		if (n % 2 == 0)
			return false;

		// check if n is divisible by any number greater than 3, up to n
		for (int i = 3; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	/**
	 * 
	 * @param n
	 *            the number to checked if prime
	 * @param divisor
	 *            a number less than n; to be divided by n
	 * @return 1 if prime, 0 if not prime
	 */
	public static int isPrime2(int n, int divisor) {
		if (divisor == 1)
			return 1;
		if (n % divisor == 0)
			return 0;
		else
			return isPrime2(n, divisor - 1);

	}

}
