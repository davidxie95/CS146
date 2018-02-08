package hw01;

public class TowerOfHanoi {

	public TowerOfHanoi() {

	}

	/**
	 * 
	 * @param n
	 *            the number of discs
	 * @param start
	 *            the initial or starting peg
	 * @param middle
	 *            the auxiliary or middle peg
	 * @param end
	 *            the destination or end peg
	 */
	public void solveHanoi(int n, String start, String middle, String end) {

		//Big O Notation: O(2^n +1)
		if (n == 1) {
			System.out.println("disk 1 move from " + start + " to " + end);
		} else {
			solveHanoi(n - 1, start, end, middle);
			System.out.println("disk " + n + " move from " + start + " to "
					+ end);
			solveHanoi(n - 1, middle, start, end);
		}

	}

	public static void main(String[] args) {

		TowerOfHanoi tower = new TowerOfHanoi();
		// change the value of num to test other numbers
		int num = 3;
		tower.solveHanoi(num, "A", "B", "C");
	}

}
