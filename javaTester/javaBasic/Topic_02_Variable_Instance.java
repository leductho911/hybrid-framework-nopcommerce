package javaBasic;

public class Topic_02_Variable_Instance {
	// biến instance "ten" kiểu String, có giá trị mặc định là null
	public String ten;

	// biến instance "tuoi" kiểu Integer, có giá trị mặc định là 0
	private int tuoi;

	// sử dụng biến ten trong một constructor
	public Topic_02_Variable_Instance(String ten) {
		this.ten = ten;
	}

	// sử dụng biến tuoi trong phương thức setTuoi
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public void showStudent() {
		System.out.println("Ten  : " + ten);
		System.out.println("Tuoi : " + tuoi);
	}

	public static void main(String args[]) {
		Topic_02_Variable_Instance sv = new Topic_02_Variable_Instance("Nguyen Van A");
		sv.setTuoi(21);
		sv.showStudent();
	}

}
