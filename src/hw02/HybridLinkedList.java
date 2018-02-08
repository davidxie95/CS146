package hw02;

class Node {
	private int data;
	public Node next;

	public Node(int data) {
		this.data = data;
	}

	public int getKey() {
		return data;
	}

	public void printNode() {
		System.out.print(data + " ");
	}
}

class LinkedList {
	private Node first;

	public LinkedList() {
		first = null;
	}

	public void add(Node node) {
		int key = node.getKey();
		Node previous = null;
		Node current = first;
		while (current != null && key > current.getKey()) {
			previous = current;
			current = current.next;
		}
		if (previous == null)
			first = node;
		else
			previous.next = node;
		node.next = current;

	}

	public void remove(int key) {
		Node previous = null;
		Node current = first;

		while (current != null && key != current.getKey()) {
			previous = current;
			current = current.next;
		}
		if (previous == null)
			first = first.next;
		else
			previous.next = current.next;
	}

	public Node search(int key) {
		Node current = first;
		while (current != null && current.getKey() <= key) {
			if (current.getKey() == key)
				return current;
			current = current.next;
		}
		return null;
	}

	public void printLinkedList() {
		Node current = first;
		while (current != null) {
			current.printNode();
			current = current.next;
		}
		System.out.print("\n");
	}

	public int getKey() {
		return first.getKey();
	}
}

/**
 * To create a Hybrid Linked List using the above inner class Node and
 * LinkedList.
 * 
 * work reference from :
 * http://www.java2s.com/Code/Java/Collections-Data-Structure
 * /Hashtablewithseparatechaining.htm
 * 
 * @author David
 *
 */
public class HybridLinkedList {
	private LinkedList[] arrayOfLinkedList;
	private int size;

	public HybridLinkedList(int size) {
		this.size = size;
		arrayOfLinkedList = new LinkedList[size];
		for (int i = 0; i < size; i++)
			arrayOfLinkedList[i] = new LinkedList();
	}

	public void printHybridLinkedList() {
		for (int i = 0; i < size; i++) {
			System.out.print(i + ": ");
			arrayOfLinkedList[i].printLinkedList();
		}
	}

	public int hashFunction(int key) {
		return key % size;
	}

	public void add(Node node) {
		int key = node.getKey();
		int value = hashFunction(key);
		arrayOfLinkedList[value].add(node);
	}

	public void remove(int key) {
		int value = hashFunction(key);
		arrayOfLinkedList[value].remove(key);
	}

	public Node getNode(int key) {
		return search(key);
	}

	public void setNode(int key) {
		Node theKey = search(key);
		add(theKey);
	}

	public Node search(int key) {
		int value = hashFunction(key);
		Node node = arrayOfLinkedList[value].search(key);
		return node;
	}

	public void sort() {
		sortHelper(arrayOfLinkedList);
	}

	private void sortHelper(LinkedList[] list) {
		if (list.length <= 1)
			return;

		// first and second
		LinkedList[] first = new LinkedList[list.length / 2];
		LinkedList[] second = new LinkedList[list.length - first.length];

		// add everything to first and second
		for (int i = 0; i < first.length; i++) {
			first[i] = list[i];
		}
		for (int i = 0; i < second.length; i++) {
			second[i] = list[i + first.length];
		}
		// recursion
		sortHelper(first);
		sortHelper(second);

		int firstPos = 0;
		int secondPos = 0;
		int i = 0;

		while (firstPos < first.length && secondPos < second.length) {
			// compare first and second
			if (first[firstPos].getKey() - second[secondPos].getKey() < 0) {

				list[i] = first[firstPos];
				firstPos++;
			} else {
				list[i] = second[secondPos];
				secondPos++;
			}
			i++;
		}

		while (firstPos < first.length) {
			list[i] = first[firstPos];
			firstPos++;
			i++;
		}
		while (secondPos < second.length) {
			list[i] = second[secondPos];
			secondPos++;
			i++;
		}

	}

}