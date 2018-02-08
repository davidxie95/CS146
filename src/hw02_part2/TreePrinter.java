package hw02_part2;

import java.util.Random;

public class TreePrinter {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		// since the bottom row is 32, we would get
		// 32 + 16 + 8 + 4 + 2 + 1 = 63 as the total number of elements
		for (int i = 0; i < 63; i++) {
			Random random = new Random();
			// adds value from 10-99
			int j = random.nextInt(90) + 10;
			tree.add(j);
		}
		System.out.println("Number of elements: " + tree.getCount());
		tree.print();

		tree.deleteRoot();

	}
}
