package hw03;

public class Tester2 {

	public static void main(String[] args) {
		// create the Heap
		Heap heap = new Heap(100);

		// add values in non-sorted order
		heap.add(99);
		heap.add(66);
		heap.add(4);
		heap.add(1);
		heap.add(55);
		heap.add(100);
		heap.add(10);
		heap.add(20);
		heap.add(50);

		// prints the Heap
		heap.print();

		System.out.println("Expect max Value: 100");
		System.out.println("Actual max Value: " + heap.deleteMax());

		System.out.println("Expect min Value: 1");
		System.out.println("Actual min Value: " + heap.deleteMin());

	}

}
