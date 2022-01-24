package week2;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2577 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int A = sc.nextInt();
//		int B = sc.nextInt();
//		int C = sc.nextInt();
//		int sum = A * B * C;
		
		int arr[] = new int[10];
		
		int sum = (sc.nextInt() * sc.nextInt() * sc.nextInt());
		sc.close();
		
		while(sum>0) {
			arr[sum%10]++;
			sum /= 10;
		}
		for(int i = 0; i < 10; i++) {
			System.out.println(arr[i]);
		}

	}

}
