package hw01;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExample {

	// ArrayList
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(new Integer(5));
		numbers.add(new Integer(1));

		System.out.println("Before Sorting");
		print(numbers);

		sort(numbers);
		System.out.println("After Sorting");
		print(numbers);
	}

	private static void sort(ArrayList<Integer> num) {
		Collections.sort(num);

	}

	private static void print(ArrayList<Integer> num) {
		for (int i = 0; i < num.size(); i++) {
			System.out.println(num.get(i));
		}

	}

}
