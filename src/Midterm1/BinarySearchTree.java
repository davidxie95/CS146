package Midterm1;

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

	/**
	 * The constructor that sets the root to null;
	 */
	public BinarySearchTree() {
		root = null;
	}

	/**
	 * add values to the tree
	 * 
	 * @param obj
	 *            takes an int and adds to the tree
	 */
	public void add(Comparable obj) {
		Node newNode = new Node();
		newNode.data = obj;
		newNode.left = null;
		newNode.right = null;
		// if the root is null, we add obj as the root
		if (root == null) {
			root = newNode;
		} else {
			// if root is not null, we use the addNode method in the node class
			root.addNode(newNode);
		}
	}

	/**
	 * the remove method for the tree
	 * 
	 * @param obj
	 *            the object to be remove
	 */
	public void remove(Comparable obj) {
		// create a node that will be remove depending on the situation
		Node toBeRemoved = root;
		Node parent = null;
		boolean found = false;
		// find the node to remove
		while (!found && toBeRemoved != null) {
			int d = toBeRemoved.data.compareTo(obj);
			if (d == 0) {
				found = true;
			} else {
				parent = toBeRemoved;
				if (d > 0)
					toBeRemoved = toBeRemoved.left;
				else
					toBeRemoved = toBeRemoved.right;
			}
		}
		if (!found) {
			return;
		}
		// after the node has been found, toBeRemoved will contain obj
		// if one children is empty, then we would use the other one
		if (toBeRemoved.left == null || toBeRemoved.right == null) {

			Node newChild;
			if (toBeRemoved.left == null)
				newChild = toBeRemoved.right;
			else
				newChild = toBeRemoved.left;
			if (parent == null)
				root = newChild;
			else if (parent.left == toBeRemoved)
				parent.left = newChild;
			else
				parent.right = newChild;
			return;
		}
		// when neither subtree is empty, find the smallest element of the right
		// substree
		Node smallestParent = toBeRemoved;
		Node smallest = toBeRemoved.right;
		while (smallest.left != null) {
			smallestParent = smallest;
			smallest = smallest.left;
		}
		// smallest is equal to the smallest element of the right child
		// move the data, and unlinked the child
		toBeRemoved.data = smallest.data;
		if (smallestParent == toBeRemoved) {
			smallestParent.right = smallest.right;
		} else {
			smallestParent.left = smallest.right;
		}
	}
}
