package hw01;

public class Insertion_Sort {

	public Insertion_Sort() {
		// TODO Auto-generated constructor stub
	}

	public static void insertionSort(int[] a) {

		for (int i = 1; i < a.length; i++) {
			int temp = a[i];
			int j;
			for (j = i - 1; i >= 0 && temp < a[j]; j--) {

				a[j + 1] = a[j];

			}
			a[j + 1] = temp;
		}
	}
}
