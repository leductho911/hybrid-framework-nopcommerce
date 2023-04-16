package javaBasic;

public class StringLearning {

	public static void main(String[] args) {

		// https://docs.google.com/document/d/1RpD3uxsctagbFXBT4CENjAgNaSKESreSQgP0p-_7anI/edit#

		// BT1
//		Scanner sc = new Scanner(System.in);
//
//		System.out.println("Input a string: ");
//		String inputString = sc.nextLine();
//
//		int count = 0;
//		for (int i = 0; i < inputString.length(); i++) {
//			if (Character.isUpperCase(inputString.charAt(i))) {
//				count++;
//			}
//		}
//
//		System.out.println("String " + inputString + " have " + count + " uppercase character(s)");

		// BT2
//		String automationString = "Automation Testing 345 Tutorials Online 789";
//		System.out.println("Index of Tutorials " + automationString.indexOf("Tutorials"));
//		automationString = automationString.replace("Online", "Offline");
//		System.out.println(automationString);

//		Count number in the string
//		int countNumber = 0;
//		for (int i = 0; i < automationString.length(); i++) {
//			if (Character.isDigit(automationString.charAt(i))) {
//				countNumber++;
//			}
//		}
//		System.out.println(countNumber);

		// check if string contains Testing
//		if (automationString.contains("Testing")) {
//			System.out.println("The string contains Testing");
//		} else {
//			System.out.println("The string does not contain Testing");
//		}

//		// count a in the string
//		int counta = 0;
//		for (int i = 0; i < automationString.length(); i++) {
//			if (automationString.charAt(i) == 'a') {
//				counta++;
//			}
//
//		}

		// BT3 Đảo ngược 1 string
		// dùng vòng lặp ngược duyệt qua chuỗi từ index-1 về index 0
		// gán từng kí tự vào chuỗi mới
		String chuoiGoc = "Le Duc Tho";
		String chuoiDao = "";
		for (int i = chuoiGoc.length() - 1; i >= 0; i--) {
			chuoiDao = chuoiDao + chuoiGoc.charAt(i);
		}
		System.out.println(chuoiDao);

	}
}
