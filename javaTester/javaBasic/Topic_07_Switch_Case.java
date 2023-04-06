package javaBasic;

public class Topic_07_Switch_Case {
	String browserName;
	String month = "2";

	public void TC_01() {
		switch (browserName) {
		case "chrome":
			System.out.println("Chrome");
			break;
		case "firefox":
			System.out.println("Firefox");
			break;
		case "edge":
			System.out.println("Edge");
			break;

		default:
			System.out.println("Not found");

			break;
		}
	}

	// Switch-case nhiều hơn 1 case
	public void TC_02() {

		switch (month) {
		case "1":
		case "3":
		case "5":
			System.out.println("Thang nay co 31 ngay");
			break;
		case "2":
			System.out.println("Thang nay co 28 hoac 29 ngay");
			break;

		default:
			System.out.println("Khong dung dinh dang");
			break;
		}
	}

}
