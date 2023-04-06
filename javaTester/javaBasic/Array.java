package javaBasic;

import java.util.Arrays;
import java.util.Scanner;

public class Array {

	public static void main(String[] args) {

//		Bài toán: Viết chương trình nhập vào một mảng gồm n số nguyên và thực hiện các công việc sau:
//			Xuất các giá trị của mảng ra
//			Tìm min, max
//			Tìm các số nguyên tố có trong mảng
//			Sắp xếp mảng theo thứ tự tăng dần
		int min = Integer.MAX_VALUE; // gán min = giá trị LỚN NHẤT của kiểu int (hơn 2 tỉ)
		int max = Integer.MIN_VALUE; // MỤC ĐÍCH: ở dòng if 27 và 30 thì luôn luôn gán được min/max = array[0] rồi
										// sau đó so sánh các phần tử khác với phần tử array[0]

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the size of the array:");
		int size = sc.nextInt();

		int[] array = new int[size];

		System.out.println("Enter the elements of the array: ");
		for (int i = 0; i < array.length; i++) {
			array[i] = sc.nextInt();
			if (array[i] > max) {
				max = array[i];
			}
			if (array[i] < min) {
				min = array[i];
			}

			boolean isPrime = true;
			if (array[i] <= 1) {
				isPrime = false;
			} else {
				for (int j = 2; j <= Math.sqrt(array[i]); j++) {
					if (array[i] % j == 0) {
						isPrime = false;
						break;
					}
				}
			}
			if (isPrime) {
				System.out.println(array[i] + "is a prime");
			}

		}
		System.out.println("The entered array is: ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}

		System.out.println("Max element is: " + max);
		System.out.println("Min element is: " + min);

		Arrays.sort(array);
		System.out.println("Sorted array: ");
		System.out.println(Arrays.toString(array));

		sc.close();

	}

}
