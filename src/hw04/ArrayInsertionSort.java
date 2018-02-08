package hw04;

import java.util.Arrays;
import java.util.Random;

/**
 * Problem 1 of hw04
 *
 */
public class ArrayInsertionSort {

	private int[] array;

	/**
	 * creates a array of size 1000
	 */
	public ArrayInsertionSort() {
		array = new int[1000];
	}

	/**
	 * Insertion sort: add and sort, or adding in sorted order. For the sort
	 * method, we are using the build in sort, "Array.sort(arrayName)"
	 */
	public void add() {

		int value = 0;
		boolean sorted = true;
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			// insert random number from 1 to 5000
			value = random.nextInt(5000) + 1;
			array[i] = value;
			// each time a new element is added, we would sort the list
			sorted = false;
		}
		if (sorted == false) {
			Arrays.sort(array);
		}
	}

	/**
	 * get the size of the array
	 * 
	 * @return the size of the array
	 */
	public int size() {
		return array.length;
	}

	/**
	 * get the index of the array, a helper print method
	 * 
	 * @param index
	 *            get the index of the array
	 * @return the value at the index of the array
	 */
	public int get(int index) {
		return array[index];
	}

	/**
	 * A tester and print method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayInsertionSort list = new ArrayInsertionSort();
		list.add();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}
}
