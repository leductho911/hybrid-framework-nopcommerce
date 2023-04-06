package javaBasic;

import org.testng.annotations.Test;

public class Topic_08_ForEach {
	String browserName;
	String month = "2";

	@Test
	public void TC_01() {
		int[] numberList = { 1, 2, 44, 4, 6, 87 };
		for (int number : numberList) {
			System.out.println(number);
			if (number == 4) {
				break;
			}
		}

	}

}
