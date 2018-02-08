package hw04;

/**
 * Problem 2 of hw04
 *
 */
public class ShellSort {
	private int[] item;

	private int length;

	public ShellSort(int max) {
		item = new int[max];
		length = 0;
	}

	public void add(int value) {
		item[length] = value;
		length++;
	}

	public void shellSort() {
		int inner, outer;
		int temp;

		int h = 1;
		while (h <= length / 3)
			h = h * 3 + 1;

		while (h > 0) {

			for (outer = h; outer < length; outer++) {

				temp = item[outer];
				inner = outer;

				while (inner > h - 1 && item[inner - h] >= temp) {
					item[inner] = item[inner - h];
					inner -= h;
				}
				item[inner] = temp;
			}
			h = (h - 1) / 3;
		}
	}

	public static void main(String[] args) {
		int maxSize = 10000;

		ShellSort arr = new ShellSort(maxSize);

		for (int i = 0; i < maxSize; i++) {
			int n = (int) (java.lang.Math.random() * 99);
			arr.add(n);
		}

		long startTime = System.nanoTime();
		arr.shellSort();
		long endTime = System.nanoTime();

		maxSize = 100000;
		ShellSort arr2 = new ShellSort(maxSize);

		for (int i = 0; i < maxSize; i++) {
			int n = (int) (java.lang.Math.random() * 99);
			arr2.add(n);
		}

		long startTime2 = System.nanoTime();
		arr2.shellSort();
		long endTime2 = System.nanoTime();

		System.out.println("Time is calculated in milliseconds" + "\n");
		System.out.println("10,000 Elements took: " + ((endTime - startTime))
				/ 1000000);

		System.out.println("100,000 Elements took: "
				+ ((endTime2 - startTime2)) / 1000000);

		maxSize = 1000000;
		ShellSort arr3 = new ShellSort(maxSize);

		for (int i = 0; i < maxSize; i++) {
			int n = (int) (java.lang.Math.random() * 99);
			arr3.add(n);
		}

		long startTime3 = System.nanoTime();
		arr3.shellSort();
		long endTime3 = System.nanoTime();

		System.out.println("1,000,000 Elements took: "
				+ ((endTime3 - startTime3)) / 1000000);

	}
}