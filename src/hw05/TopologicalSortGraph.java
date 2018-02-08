package hw05;

import java.util.LinkedList;
import java.util.Queue;

class Node {
	public String data;
	public int dist;
	public int inDegree;
	LinkedList<Node> AdjacenctNode = new LinkedList<Node>();

	public void addAdjNode(final Node Child) {
		AdjacenctNode.add(Child);
		Child.inDegree++;
	}

	public Node(String data) {
		super();
		this.data = data;
	}
}

public class TopologicalSortGraph {

	/**
	 * This Topological Sort implementation takes the example graph in Version
	 * 1: implementation with unweighted Assumption : Graph is directed
	 */
	TopologicalSortGraph Graph = new TopologicalSortGraph();

	// public LinkedList<Node> nodes = new LinkedList<Node>();

	public static void topologicalSort(Graph graph) {
		Queue<Node> q = new LinkedList<Node>();
		int vertexProcessesCtr = 0;
		for (Node m : graph.nodes) {
			if (m.inDegree == 0) {
				++vertexProcessesCtr;
				q.add(m);
				System.out.println(m.data);
			}
		}
		while (!q.isEmpty()) {
			Node m = q.poll();

			// System.out.println(m.data);
			for (Node child : m.AdjacenctNode) {
				--child.inDegree;
				if (child.inDegree == 0) {
					q.add(child);
					++vertexProcessesCtr;
					System.out.println(child.data);
				}
			}

		}
		if (vertexProcessesCtr > graph.vertices) {
			System.out.println();
		}

	}

	public static void main(String[] args) {
		Graph g = new Graph();
		g.vertices = 8;

		Node TEN = new Node("10");
		Node ELEVEN = new Node("11");
		Node TWO = new Node("2");
		Node THREE = new Node("3");
		Node FIVE = new Node("5");
		Node SEVEN = new Node("7");
		Node EIGHT = new Node("8");
		Node NINE = new Node("9");

		SEVEN.AdjacenctNode.add(ELEVEN);
		ELEVEN.inDegree++;
		SEVEN.AdjacenctNode.add(EIGHT);
		EIGHT.inDegree++;
		FIVE.AdjacenctNode.add(ELEVEN);
		ELEVEN.inDegree++;
		THREE.AdjacenctNode.add(EIGHT);
		EIGHT.inDegree++;
		THREE.AdjacenctNode.add(TEN);
		TEN.inDegree++;
		ELEVEN.AdjacenctNode.add(TEN);
		TEN.inDegree++;
		ELEVEN.AdjacenctNode.add(TWO);
		TWO.inDegree++;
		ELEVEN.AdjacenctNode.add(NINE);
		NINE.inDegree++;
		EIGHT.AdjacenctNode.add(NINE);
		NINE.inDegree++;

		g.nodes.add(TWO);
		g.nodes.add(THREE);
		g.nodes.add(FIVE);
		g.nodes.add(SEVEN);
		g.nodes.add(EIGHT);
		g.nodes.add(NINE);

		System.out.println("Now calling the topologial sorts");

		topologicalSort(g);

	}
}