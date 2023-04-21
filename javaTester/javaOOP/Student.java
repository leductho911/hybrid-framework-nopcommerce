package javaOOP;

public class Student extends Person {

	public Student(String name, int age, float height) {
		super(name, age, height);
	}

	public static void main(String[] args) {
		Student a = new Student("Chau", 21, 1.7f);
		a.getInfo();
	}
}
