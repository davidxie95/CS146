package hw03;

public class Tester {

	public static void main(String[] args) {
		Employee John = new Employee("John", 123, 2);
		System.out.println("Expected: 2314539");
		System.out.println("Actual: " + John.hashCode());

		Employee Josh = new Employee("Josh", 123, 2);
		System.out.println("Expected: 2314874");
		System.out.println("Actual: " + Josh.hashCode());

		// an employee with the same name but different salary
		Employee Josh2 = new Employee("Josh", 1234, 2);
		System.out.println("Expected: 1450575236");
		System.out.println("Actual: " + Josh2.reHash());

		// Note that if the same is the same, we will get the same hash value
		System.out.println("Expected: 2314874");
		System.out.println("Actual: " + Josh2.hashCode());

	}

}
