package Midterm2;

/**
 * A node class for a Leftist Heap
 *
 */
class LeftHeapNode {
	int element, sValue;
	LeftHeapNode left, right;

	/**
	 * Constructor for the root
	 * 
	 * @param element
	 *            the root
	 */
	public LeftHeapNode(int element) {
		this(element, null, null);
	}

	/**
	 * Constructor for children of the root
	 * 
	 * @param element
	 *            the element to be inserted
	 * @param left
	 *            the left child
	 * @param right
	 *            the right child
	 */
	public LeftHeapNode(int element, LeftHeapNode left, LeftHeapNode right) {
		this.element = element;
		this.left = left;
		this.right = right;
		this.sValue = 0;
	}
}

/**
 * To implement a LeftisHeap with a merge function.
 *
 */
public class LeftistHeap {
	private LeftHeapNode root;

	/**
	 * The Constructor, will set the root null
	 */
	public LeftistHeap() {
		root = null;
	}

	/**
	 * check if the root is empty
	 * 
	 * @return true if root exists, else false
	 */
	public boolean isEmpty() {
		return root == null;
	}

	/**
	 * make the Leftist Heap empty
	 */
	public void clear() {
		root = null;
	}

	/**
	 * A add method
	 * 
	 * @param x
	 */
	public void insert(int x) {
		root = merge(new LeftHeapNode(x), root);
	}

	/**
	 * a merge fuction
	 * 
	 * @param rhs
	 *            to merge 2 leftistHeap together
	 */
	public void merge(LeftistHeap rhs) {
		if (this == rhs)
			return;
		root = merge(root, rhs.root);
		rhs.root = null;
	}

	/**
	 * helper method for the merge method
	 * 
	 * @param x
	 *            the first Heap to be merge
	 * @param y
	 *            the second Heap to be merge
	 * @return a new Heap that consists of both x and y Heap
	 */
	private LeftHeapNode merge(LeftHeapNode x, LeftHeapNode y) {
		if (x == null)
			return y;
		if (y == null)
			return x;
		if (x.element > y.element) {
			LeftHeapNode temp = x;
			x = y;
			y = temp;
		}

		x.right = merge(x.right, y);

		if (x.left == null) {
			x.left = x.right;
			x.right = null;
		} else {
			if (x.left.sValue < x.right.sValue) {
				LeftHeapNode temp = x.left;
				x.left = x.right;
				x.right = temp;
			}
			x.sValue = x.right.sValue + 1;
		}
		return x;
	}

	/**
	 * Function to delete the minimum value
	 * 
	 * @return the value to be deleted
	 */
	public int deleteMin() {
		if (isEmpty())
			return -1;
		int minItem = root.element;
		root = merge(root.left, root.right);
		return minItem;
	}

	/** Inorder traversal **/
	public void inorder() {
		inorder(root);
		System.out.println();
	}

	/**
	 * helper method for the print method
	 * 
	 * @param r
	 *            takes the Heap and prints it
	 */
	private void inorder(LeftHeapNode r) {
		if (r != null) {
			inorder(r.left);
			System.out.print(r.element + " ");
			inorder(r.right);
		}
	}
}
