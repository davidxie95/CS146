package Midterm2;

public class HeapTester {

	public static void main(String[] args) {

		// first heap
		LeftistHeap heap = new LeftistHeap();
		// add 7 elements, or 3 levels worth of elements
		for (int i = 1; i <= 7; i++) {
			heap.insert(i);
		}

		System.out.println("Expected: 4 3 5 1 6 2 7");
		System.out.print("Actual:   ");
		heap.inorder();

		// second heap
		LeftistHeap heap2 = new LeftistHeap();
		for (int i = 1; i <= 7; i++) {
			heap2.insert(i + 7);
		}
		System.out.println("Expected: 11 10 12 8 13 9 14");
		System.out.print("Actual:   ");
		heap2.inorder();

		// merge the 2 heap and print
		heap.merge(heap2);
		System.out.println("Expected: 4 3 5 1 6 2 11 10 12 8 13 9 14 7");
		System.out.print("Actual:   ");
		heap.inorder();

		// insert keys into a empty leftist Heap
		LeftistHeap heap3 = new LeftistHeap();
		heap3.clear();
		heap3.merge(heap);
		System.out.println("Expected: 4 3 5 1 6 2 11 10 12 8 13 9 14 7");
		System.out.print("Actual:   ");
		heap3.inorder();

	}
}
