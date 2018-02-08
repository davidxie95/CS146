package hw02_part2;

class Node {
	public Comparable data;
	public Node left;
	public Node right;

	/**
	 * an add method for the Node class
	 * 
	 * @param newNode
	 *            takes an Node and adds in sorted order
	 */
	public void addNode(Node newNode) {
		// compare the newNode
		int comp = newNode.data.compareTo(data);
		// if less the root or parent Node, then adds to left side
		if (comp < 0) {
			if (left == null) {
				left = newNode;
			} else {
				left.addNode(newNode);
			}
			// if greater than root or the parent Node, then adds to right side
		} else if (comp > 0) {
			if (right == null) {
				right = newNode;
			} else {
				right.addNode(newNode);
			}
		}
	}
}

/**
 * to create a Binary Search Tree by creating a comparable Node class that adds
 * elements in sorted order
 * 
 * @author David
 *
 */
public class BinarySearchTree {

	private Node root;
	private int count;

	/**
	 * The constructor that sets the root to null;
	 */
	public BinarySearchTree() {
		root = null;
		count = 0;
	}

	/**
	 * add values to the tree
	 * 
	 * @param obj
	 *            takes an int and adds to the tree
	 */
	public void add(int obj) {
		// create new node, set its children (both left and right) to null
		// values
		Node newNode = new Node();
		newNode.data = obj;
		newNode.left = null;
		newNode.right = null;
		if (root == null) {
			root = newNode;
			count++;
		} else {
			root.addNode(newNode);
			count++;
		}
	}

	public int getRoot() {

		return (int) root.data;
	}

	public int getCount() {
		return count;
	}

	/**
	 * part d of problem number 3, delete the root and print the tree until the
	 * tree is empty
	 */
	public void deleteRoot() {

		// method does not currently work
		Node newNode = root;
		// while the tree is not empty
		while (count != 0) {
			// when the number of elements in the tree is odd, get the left
			// subtree and push it into the root
			if (count % 2 != 0) {
				root = newNode.left;
				count--;
				System.out.println("Number of elements: " + getCount());
				print();
			}
			// else if tree is even, use the right subtrees
			else  {
				root = newNode.right;
				count--;
				System.out.println("Number of elements: " + getCount());
				print();
			}

		}
	}

	/**
	 * a print method that prints the root
	 */
	public void print() {
		print(root);
		System.out.println();
	}

	/**
	 * will take the root and print all the children (both left and right side)
	 * in sorted order
	 * 
	 * @param parent
	 *            takes the root
	 */
	private static void print(Node parent) {
		if (parent == null) {
			return;
		}
		print(parent.left);
		System.out.println(parent.data + " ");
		print(parent.right);
	}
}
