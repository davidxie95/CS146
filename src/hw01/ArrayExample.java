package hw01;

import java.util.Arrays;

public class ArrayExample {

	// Array
	public static void main(String[] args) {
		int numbers[] = new int[] { 5, 1, 9, 4, 7 };
		System.out.println("Before Sorting");
		print(numbers);

		sort(numbers);
		System.out.println("After Sorting");
		print(numbers);
	}

	private static void sort(int[] numbers) {
		Arrays.sort(numbers);

	}

	private static void print(int[] numbers) {
		for (int i : numbers) {
			System.out.println(i);
		}

	}

}
