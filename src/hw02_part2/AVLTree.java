package hw02_part2;

/**
 * AVL Node class, work cited from:
 * http://www.sanfoundry.com/java-program-implement-avl-tree/
 */
class AVLNode {
	AVLNode left, right;
	int data;
	int height;

	/**
	 * Constructor
	 */
	public AVLNode() {
		left = null;
		right = null;
		data = 0;
		height = 0;
	}

	/**
	 * a constructor that takes a parameter for the value of the node
	 * 
	 * @param n
	 *            the value of the node
	 */
	public AVLNode(int n) {
		left = null;
		right = null;
		data = n;
		height = 0;
	}
}

public class AVLTree {
	private AVLNode root;

	/**
	 * Constructor
	 */
	public AVLTree() {
		root = null;
	}

	/**
	 * add values to the tree
	 * 
	 * @param data
	 *            the data of the node that will be added to the tree
	 */
	public void add(int data) {
		root = add(data, root);
	}

	/**
	 * get the height of the tree
	 * 
	 * @param t
	 *            height of the node
	 * @return the height of the given node (t)
	 */
	private int getHeight(AVLNode t) {
		return t == null ? -1 : t.height;
	}

	/**
	 * get the max value of the left or right most node, for rotational purposes
	 * 
	 * @param lhs
	 *            left node
	 * @param rhs
	 *            right node
	 * @return the max between the left and right node
	 */
	private int max(int lhs, int rhs) {
		return lhs > rhs ? lhs : rhs;
	}

	/**
	 * Function to insert data recursively
	 * 
	 * @param x
	 *            the data
	 * @param t
	 *            the node of the data
	 * @return the node of the data that will be inserted
	 */
	private AVLNode add(int x, AVLNode t) {
		if (t == null)
			t = new AVLNode(x);
		else if (x < t.data) {
			t.left = add(x, t.left);
			if (getHeight(t.left) - getHeight(t.right) == 2)
				if (x < t.left.data)
					t = rotateWithLeftChild(t);
				else
					t = doubleWithLeftChild(t);
		} else if (x > t.data) {
			t.right = add(x, t.right);
			if (getHeight(t.right) - getHeight(t.left) == 2)
				if (x > t.right.data)
					t = rotateWithRightChild(t);
				else
					t = doubleWithRightChild(t);
		} else
			; // if node is a Duplicate, ignore it
		t.height = max(getHeight(t.left), getHeight(t.right)) + 1;
		return t;
	}

	/**
	 * Rotate binary tree node with left child
	 * 
	 * @param k2
	 *            the node that will be rotated
	 * @return the node for rotation
	 */
	private AVLNode rotateWithLeftChild(AVLNode k2) {
		AVLNode k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = max(getHeight(k2.left), getHeight(k2.right)) + 1;
		k1.height = max(getHeight(k1.left), k2.height) + 1;
		return k1;
	}

	/**
	 * Rotate binary tree node with right child
	 * 
	 * @param k1
	 *            the node that will be rotated
	 * @return the node for rotation
	 */
	private AVLNode rotateWithRightChild(AVLNode k1) {
		AVLNode k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		k1.height = max(getHeight(k1.left), getHeight(k1.right)) + 1;
		k2.height = max(getHeight(k2.right), k1.height) + 1;
		return k2;
	}

	/**
	 * Double rotate binary tree node: first left child with its right child;
	 * then node k3 with new left child
	 */
	private AVLNode doubleWithLeftChild(AVLNode k3) {
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}

	/**
	 * Double rotate binary tree node: first right child with its left child;
	 * then node k1 with new right child
	 */
	private AVLNode doubleWithRightChild(AVLNode k1) {
		k1.right = rotateWithLeftChild(k1.right);
		return rotateWithRightChild(k1);
	}

	/**
	 * count the number of nodes
	 * 
	 * @return the number of nodes
	 */
	public int countNodes() {
		return countNodes(root);
	}

	/**
	 * recursive helper method
	 * 
	 * @param r
	 *            takes an AVLNode
	 * @return 0 if root is null, else return a count of the left + right nodes
	 */
	private int countNodes(AVLNode r) {
		if (r == null)
			return 0;
		else {
			int l = 1;
			l += countNodes(r.left);
			l += countNodes(r.right);
			return l;
		}
	}

	/**
	 * a print method for testing purposes
	 */
	public void print() {
		print(root);
		System.out.println();
	}

	private static void print(AVLNode parent) {
		if (parent == null) {
			return;
		}
		print(parent.left);
		System.out.println(parent.data + " ");
		print(parent.right);
	}

	/**
	 * part d of problem number 4, delete the root and print the tree until the
	 * tree is empty
	 */
	public void deleteRoot() {
		AVLNode newNode = root;
		for (int i = 0; i < countNodes(); i++) {
			if (countNodes() % 2 != 0) {
				root = newNode.left;
				System.out.println("Number of elements: " + countNodes());
				print();
			}
			// else if tree is even, use the right subtrees
			else {
				root = newNode.right;
				System.out.println("Number of elements: " + countNodes());
				print();
			}
		}
	}

}
