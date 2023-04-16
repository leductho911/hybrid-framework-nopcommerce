package javaBasic;

//		Viết chương trình hiển thị thông tin học sinh với
//		Thuộc tính: ID, Name, Age, Score
//		Hàm khởi tạo giá trị cho các thuộc tính
//		Phương thức: displayed() - in ra console ID/ Name/ Age/ Score (Point)
//		BT7 https://docs.google.com/document/d/1wOWnRm5UEhYFWuVRW0qwVsCOEeYn5xxLZFzO3fjmXWo/edit#heading=h.88hjo26lwva1
// 		https://youtu.be/ilIGZLm00zM?t=6574

public class Array_Object {
	String name;
	int age;

	// Constructor
	public Array_Object(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void display() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
	}

	public static void main(String[] args) {
		Array_Object[] students = new Array_Object[3];

		students[0] = new Array_Object("Tuan", 24);
		students[1] = new Array_Object("Cuong", 25);
		students[2] = new Array_Object("Duc", 24);
		for (int i = 0; i < 3; i++) {
			students[i].display();
		}
	}
}
