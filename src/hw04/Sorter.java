package hw04;

import java.util.Random;

/**
 * Work Reference From:
 * 
 * http://www.sanfoundry.com/java-program-implement-heap-sort/ Java Program to
 * Implement Heap Sort
 * 
 * http://java2novice.com/java-sorting-algorithms/merge-sort/
 * 
 * http://www.programcreek.com/2012/11/quicksort-array-in-java/
 */

class Node {
	public int item;
	public Node next;

	public Node(int val) {
		item = val;
	}

	public Node() {
	}
}

class LinkedList {
	private Node first;

	public LinkedList() {
		first = null;
	}

	public void add(int val) {
		Node newNode = new Node(val);
		newNode.next = first;
		first = newNode;
	}

	public Node MergeSort(Node headOriginal) {
		if (headOriginal == null || headOriginal.next == null)
			return headOriginal;
		Node a = headOriginal;
		Node b = headOriginal.next;
		while ((b != null) && (b.next != null)) {
			headOriginal = headOriginal.next;
			b = (b.next).next;
		}
		b = headOriginal.next;
		headOriginal.next = null;
		return merge(MergeSort(a), MergeSort(b));
	}

	private Node merge(Node a, Node b) {
		Node temp = new Node();
		Node head = temp;
		Node c = head;
		while ((a != null) && (b != null)) {
			if (a.item <= b.item) {
				c.next = a;
				c = a;
				a = a.next;
			} else {
				c.next = b;
				c = b;
				b = b.next;
			}
		}
		c.next = (a == null) ? b : a;
		return head.next;
	}

	public Node extractFirst() {
		return first;
	}
}

public class Sorter {
	private int N;
	private int[] array;
	private int[] tempMergArr;
	private int length;

	/**
	 * Constructor
	 */
	public Sorter() {

	}

	/* Sort Function */
	public void heapSort(int arr[]) {
		heapify(arr);
		for (int i = N; i > 0; i--) {
			swap(arr, 0, i);
			N = N - 1;
			maxheap(arr, 0);
		}
	}

	/* Function to build a heap */
	private void heapify(int arr[]) {
		N = arr.length - 1;
		for (int i = N / 2; i >= 0; i--)
			maxheap(arr, i);
	}

	/* Function to swap largest element in heap */
	private void maxheap(int arr[], int i) {
		int left = 2 * i;
		int right = 2 * i + 1;
		int max = i;
		if (left <= N && arr[left] > arr[i])
			max = left;
		if (right <= N && arr[right] > arr[max])
			max = right;

		if (max != i) {
			swap(arr, i, max);
			maxheap(arr, max);
		}
	}

	/* Function to swap two numbers in an array */
	private void swap(int arr[], int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	/**
	 * Merge sort
	 * 
	 * @param inputArr
	 */
	public void mergeSort(int inputArr[]) {

		this.array = inputArr;
		this.length = inputArr.length;
		this.tempMergArr = new int[length];
		doMergeSort(0, length - 1);
	}

	private void doMergeSort(int lowerIndex, int higherIndex) {

		if (lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			// Below step sorts the left side of the array
			doMergeSort(lowerIndex, middle);
			// Below step sorts the right side of the array
			doMergeSort(middle + 1, higherIndex);
			// Now merge both sides
			mergeParts(lowerIndex, middle, higherIndex);
		}
	}

	private void mergeParts(int lowerIndex, int middle, int higherIndex) {

		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempMergArr[i] = array[i];
		}
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while (i <= middle && j <= higherIndex) {
			if (tempMergArr[i] <= tempMergArr[j]) {
				array[k] = tempMergArr[i];
				i++;
			} else {
				array[k] = tempMergArr[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			array[k] = tempMergArr[i];
			k++;
			i++;
		}

	}

	public void quickSort(int[] arr, int low, int high) {
		if (arr == null || arr.length == 0)
			return;

		if (low >= high)
			return;

		// pick the pivot
		int middle = low + (high - low) / 2;
		int pivot = arr[middle];

		// make left < pivot and right > pivot
		int i = low, j = high;
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}

			while (arr[j] > pivot) {
				j--;
			}

			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}

		// recursively sort two sub parts
		if (low < j)
			quickSort(arr, low, j);

		if (high > i)
			quickSort(arr, i, high);
	}

	/**
	 * Tester and print methods
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Sorter heap = new Sorter();
		// an array of size 10,000 and 100,000 respectively
		int[] array1 = new int[10000];
		int[] array2 = new int[100000];

		int value = 0;
		Random random = new Random();

		for (int i = 0; i < array1.length; i++) {
			// add random number between 1 to 50,000
			value = random.nextInt(50000) + 1;
			array1[i] = value;
		}
		long startTime = System.nanoTime();
		heap.heapSort(array1);
		long endTime = System.nanoTime();

		for (int i = 0; i < array2.length; i++) {
			// add random number between 1 to 500,000
			value = random.nextInt(500000) + 1;
			array2[i] = value;
		}
		long startTime2 = System.nanoTime();
		heap.heapSort(array2);
		long endTime2 = System.nanoTime();

		for (int i = 0; i < array1.length; i++) {
			// add random number between 1 to 50,000
			value = random.nextInt(50000) + 1;
			array1[i] = value;
		}
		Sorter merge = new Sorter();
		long startTime3 = System.nanoTime();
		merge.mergeSort(array1);
		long endTime3 = System.nanoTime();

		for (int i = 0; i < array2.length; i++) {
			// add random number between 1 to 500,000
			value = random.nextInt(500000) + 1;
			array2[i] = value;
		}
		long startTime4 = System.nanoTime();
		merge.mergeSort(array2);
		long endTime4 = System.nanoTime();

		int[] arrayQuickSort = new int[10000];

		Sorter quick = new Sorter();
		for (int i = 0; i < arrayQuickSort.length; i++) {
			// add random number between 1 to 50,000
			value = random.nextInt(50000) + 1;
			arrayQuickSort[i] = value;
		}
		int low = 0;
		int high = arrayQuickSort.length - 1;
		long startTimeQ = System.nanoTime();
		quick.quickSort(arrayQuickSort, low, high);
		long endTimeQ = System.nanoTime();

		int[] arrayQuickSort2 = new int[100000];
		for (int i = 0; i < arrayQuickSort2.length; i++) {
			// add random number between 1 to 500,000
			value = random.nextInt(500000) + 1;
			arrayQuickSort2[i] = value;
		}
		int high2 = arrayQuickSort2.length - 1;

		long startTimeQ2 = System.nanoTime();
		quick.quickSort(arrayQuickSort2, low, high2);
		long endTimeQ2 = System.nanoTime();

		// merge sort for linked list
		LinkedList object = new LinkedList();
		for (int i = 0; i < 10000; i++)
			object.add(Math.abs(random.nextInt(50000) + 1));

		long startTimeM = System.nanoTime();
		object.MergeSort(object.extractFirst());
		long endTimeM = System.nanoTime();

		LinkedList object2 = new LinkedList();
		for (int i = 0; i < 100000; i++)
			object2.add(Math.abs(random.nextInt(500000) + 1));

		long startTimeM2 = System.nanoTime();
		object2.MergeSort(object2.extractFirst());
		long endTimeM2 = System.nanoTime();

		// time it took for HeapSort in milliseconds
		System.out.println("Time is calculated in milliseconds" + "\n");
		System.out.println("10,000 Elements");
		// get the value in nanoseconds then divided by 1,000,000
		System.out.println("HeapSort: " + ((endTime - startTime) / 1000000));
		System.out.println("MergeSort: " + (endTime3 - startTime3) / 1000000);
		System.out.println("QuickSort: " + (endTimeQ - startTimeQ) / 1000000);
		System.out.println("MergeSort (Linked List): "
				+ (endTimeM - startTimeM) / 1000000);

		System.out.println("\n" + "100,000 Elements");
		System.out.println("HeapSort: " + (endTime2 - startTime2) / 1000000);
		System.out.println("MergeSort: " + (endTime4 - startTime4) / 1000000);
		System.out.println("QuickSort: " + (endTimeQ2 - startTimeQ2) / 1000000);
		System.out.println("MergeSort (Linked List): "
				+ (endTimeM2 - startTimeM2) / 1000000);

	}
}