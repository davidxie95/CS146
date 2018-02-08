package hw02_part2;

import java.util.Random;

public class AVL_Tree_Tester {
	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		// add 35 integer to the list
		for (int i = 0; i < 42; i++) {
			Random random = new Random();
			// adds value from 10-99
			int j = random.nextInt(90) + 10;
			tree.add(j);
		}
		System.out.println("Number of Elements:" + tree.countNodes());
		tree.print();

		// tree.deleteRoot();

	}
}