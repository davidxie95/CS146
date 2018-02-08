package Midterm1;

import java.util.Scanner;
import java.util.Stack;

//Problem 4

public class Postfix {

	/**
	 * to evaluate postfix expression
	 * 
	 * @param postfix
	 *            input to be checked
	 * @return the postfix expression after it has been evaluated.
	 */
	public int evaluatePF(String postfix) {
		// create a scanner that takes @param postfix
		// and evaluate the postfix expression
		Scanner sc = new Scanner(postfix);
		Stack<Integer> stack = new Stack<Integer>();

		// scan the string and if integer push to stack
		while (sc.hasNext()) {
			if (sc.hasNextInt()) {
				stack.push(sc.nextInt());
				continue;
			}

			// pop first two
			int a = stack.pop();
			int b = stack.pop();

			// checks for operands
			char op = sc.next().charAt(0);
			// evaluate the postfix expressions
			if (op == '+')
				stack.push(a + b);
			else if (op == '-')
				stack.push(a - b);
			else if (op == '*')
				stack.push(a * b);
			else if (op == '/')
				stack.push(a / b);
			else if (op == '%')
				stack.push(a % b);
		}

		// pop the stack
		sc.close();
		return stack.pop();
	}

	/**
	 * Checks if the input is operator or not
	 * 
	 * @param c
	 *            input to be checked
	 * @return true if operator
	 */
	private boolean isOperator(char c) {
		if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^')
			return true;
		return false;
	}

	/**
	 * Converts any postfix to infix
	 * 
	 * @param postfix
	 *            String expression to be converted
	 * @return String infix expression produced
	 */
	public String convert(String postfix) {
		// create a stack, and scan from left to right of the string
		Stack<String> s = new Stack<>();

		for (int i = 0; i < postfix.length(); i++) {
			char c = postfix.charAt(i);

			// if i is a operator, pop first 2
			if (isOperator(c)) {
				String b = s.pop();
				String a = s.pop();
				// operand2 + operator + operand1, and push to stack
				s.push("(" + a + c + b + ")");
			} else
				// if i is NOT an operator, just push the stack
				s.push("" + c);
		}

		// pop element on stack
		return s.pop();
	}

	// a testing main
	public static void main(String[] args) {

		Postfix obj = new Postfix();
		Postfix obj2 = new Postfix();
		// create a scanner for testing purposes
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a Postfix Expression: ");
		// takes user input and convert to postfix

		String postfix = in.next();
		System.out.println("Infix Expression: " + obj.convert(postfix));
		String ram = in.next();

		System.out.println("Evaluated Postfix Expression: "
				+ obj2.evaluatePF(ram));

	}
}