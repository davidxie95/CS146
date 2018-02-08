package hw03;

//the given class in figure 5.08 in the text book
public class Employee {

	// a given equals method given by the Employee class
	public boolean equals(Object rhs) {
		return rhs instanceof Employee && name.equals(((Employee) rhs).name);
	}

	// the given hash method
	public int hashCode() {
		return name.hashCode();
	}

	private String name;
	private double salary;
	private int seniority;

	// a basic constructor
	public Employee(String name, double salary, int seniority) {
		this.name = name;
		this.salary = salary;
		this.seniority = seniority;

	}

	// a hash method if name is same
	public int reHash() {

		String temp = Double.toString(salary);
		return temp.hashCode();
	}
}
