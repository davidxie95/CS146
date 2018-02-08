package hw03;

/**
 * Work reference from:
 * http://www.sanfoundry.com/java-program-implement-max-heap/
 * 
 * a min-max heap class
 *
 */
public class Heap {

	private int[] Heap;
	private int size;
	private int maxsize;

	/**
	 * The Heap Constructor
	 * 
	 * @param maxsize
	 *            the size of the Heap
	 */
	public Heap(int maxsize) {
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new int[this.maxsize + 1];
		Heap[0] = Integer.MAX_VALUE;

	}

	private int parent(int pos) {
		return pos / 2;
	}

	private int leftChild(int pos) {
		return (2 * pos);
	}

	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}

	private boolean isLeaf(int pos) {
		if (pos >= (size / 2) && pos <= size) {
			return true;
		}
		return false;
	}

	/**
	 * swap the position of the left and right child
	 * 
	 * @param fpos
	 *            first position of the node, will be swap to second
	 * @param spos
	 *            second position of the node, will be swap to the first
	 */
	private void swap(int fpos, int spos) {
		int tmp;
		tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}

	/**
	 * add data to the Heap in sorted order
	 * 
	 * @param data
	 *            the data that will be added to the Heap
	 */
	public void add(int data) {

		Heap[++size] = data;
		int current = size;

		while (Heap[current] > Heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	/**
	 * Delete the lowest value in the Heap. it only returns the value to be
	 * deleted instead of deleting the value itself, this is easier for testing
	 * purposes
	 * 
	 * @return the lowest value to be remove
	 */
	public int deleteMin() {
		int lowest = 0;
		for (int i = 0; i < Heap.length - 1; i++) {

			int temp = Heap[i];
			int temp2 = Heap[i + 1];

			if (temp < temp2)
				lowest = temp;
		}
		return lowest;
	}

	/**
	 * delete the maximum value of the Heap, it only returns the value to be
	 * deleted instead of deleting the value itself, this is easier for testing
	 * purposes
	 * 
	 * @return the maximum value to be remove
	 */
	public int deleteMax() {

		int popped = Heap[1];
		Heap[1] = Heap[size--];
		maxHeapify(1);
		return popped;
	}

	/**
	 * helper method to delete the max value of the Heap. Helper method improve
	 * run time of deleteMax to log n time
	 * 
	 * @param pos
	 *            takes the a position of a Heap
	 */
	private void maxHeapify(int pos) {
		// if node is not a leaf
		if (!isLeaf(pos)) {
			// compare node with left and right child
			if (Heap[pos] < Heap[leftChild(pos)]
					|| Heap[pos] < Heap[rightChild(pos)]) {
				// if left child is greater than right child, we swap
				if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) {
					swap(pos, leftChild(pos));
					maxHeapify(leftChild(pos));
					// if right node is less than left node, we swap
				} else {
					swap(pos, rightChild(pos));
					maxHeapify(rightChild(pos));
				}
			}
		}
	}

	/**
	 * a print method for testing purpose
	 */
	public void print() {
		for (int i = 1; i <= size / 2; i++) {
			System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : "
					+ Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]);
			System.out.println();
		}
	}
}
