package hw02;

/**
 * Java Program to Solve Tower of Hanoi Problem using Stacks
 * credits to http://www.sanfoundry.com/java-program-implement-solve-tower-of-hanoi-using-stacks/
 */
import java.util.*;

public class TowerOfHanoiStacks {
	public static int N;
	// Creating Stack array
	public static Stack<Integer>[] tower = new Stack[4];

	public static void main(String[] args) {
		tower[1] = new Stack<Integer>();
		tower[2] = new Stack<Integer>();
		tower[3] = new Stack<Integer>();
		// change num into any numbers
		int num = 5;
		towerOfHanoi(num);
	}

	// push disk into stack
	public static void towerOfHanoi(int n) {
		for (int i = n; i > 0; i--)
			tower[1].push(i);
		move(n, 1, 2, 3);
	}

	public static void move(int n, int a, int b, int c) {
		if (n > 0) {
			move(n - 1, a, c, b);
			int d = tower[a].pop();
			tower[c].push(d);
			System.out.println("disk " + n + " move from " + a + " to " + c);
			move(n - 1, b, a, c);

		}
	}

}
