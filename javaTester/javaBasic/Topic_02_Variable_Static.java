package javaBasic;

public class Topic_02_Variable_Static {
	// biến static 'ten'
	public static String ten = "Nguyen Van A";

	// biến static 'tuoi'
	public static int tuoi = 21;

	public static void main(String args[]) {
		// Sử dụng biến static bằng cách gọi trực tiếp
		System.out.println("Ten : " + ten);

		// Sử dụng biến static bằng cách gọi thông qua tên class
		System.out.println("Ten : " + Topic_02_Variable_Static.tuoi);

	}
}
