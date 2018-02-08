package hw02;

import java.io.IOException;

public class HybridLinkedListTester {

	public static void main(String[] args) throws IOException {
		int key = 0;
		Node data;
		int size = 100;

		HybridLinkedList list = new HybridLinkedList(size);

		for (int i = 0; i < 100; i++) {
			// a random function
			key = (int) (java.lang.Math.random() * (int) Math.pow(size, 2));
			data = new Node(key);
			list.add(data);
		}
		// list.sort();
		list.printHybridLinkedList();
		
	}

}
