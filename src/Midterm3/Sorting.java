package Midterm3;

// Work reference from http://mathworld.wolfram.com/BinomialCoefficient.html
// and work reference from: http://stackoverflow.com/questions/32663033/arrayindexoutofbounds-in-binomial-cofficient-dynamic-programming

public class Sorting {

	public static void main(String arg[]) {

		int n = 0;
		int k = 0;
		// only one outcome that is (0,0)
		System.out.println("Expected: 1");
		System.out.println("Actual: " + binomialCoeff(n, k));

		n = 33;
		k = 34;
		// no output because 34 cannot go into 33
		System.out.println("Expected: 0");
		System.out.println("Actual: " + binomialCoeff(n, k));

		n = 4;
		k = 2;
		// 6 outputs
		// (1,2) (1,3) (1,4) (2,3) (2,4) (3,4)
		System.out.println("Expected: 6");
		System.out.println("Actual: " + binomialCoeff(n, k));

		n = 3;
		k = 2;
		// 3 outputs
		// (1,2) (1,3) (2,3)
		System.out.println("Expected: 3");
		System.out.println("Actual: " + binomialCoeff(n, k));

	}

	/**
	 * return the smaller number between a and b
	 * 
	 * @param a
	 *            first integer
	 * @param b
	 *            second integer
	 * @return a or b depending on who is smaller
	 */
	static int min(int a, int b) {
		return (a < b) ? a : b;
	}

	/**
	 * calculate the binomial coefficient by using n choose k
	 * 
	 * @param n
	 *            n will choose k
	 * @param k
	 *            k will go into n
	 * @return the binomial coefficient
	 */
	static int binomialCoeff(int n, int k) {
		int[][] C = new int[n + 1][k + 1];
		int i, j;
		for (i = 0; i <= n; i++) {
			for (j = 0; j <= min(i, k); j++) {
				if (j == 0 || j == i)
					C[i][j] = 1;
				else
					C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
			}
		}
		return C[n][k];
	}

}