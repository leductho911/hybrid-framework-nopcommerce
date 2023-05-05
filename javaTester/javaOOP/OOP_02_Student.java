package javaOOP;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OOP_02_Student {
	private int studentID;
	private String studentName;
	private float mathPoint;
	private float physicsPoint;

	public OOP_02_Student(int studentID, String studentName, float mathPoint, float physicsPoint) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.mathPoint = mathPoint;
		this.physicsPoint = physicsPoint;
	}

	
	public float getAveragePoint() {
		return (mathPoint + physicsPoint * 2) / 3;
	}

	public void printStudentInfo() {
		System.out.println("Student ID:" + this.studentID);
		System.out.println("Student Name:" + this.studentName);
		System.out.println("Average point:" + getAveragePoint());
	}

	public static void main(String[] args) {
		OOP_02_Student student1 = new OOP_02_Student(1, "Nam", 9.25f, 5.75f);
		student1.printStudentInfo();

	}

}
