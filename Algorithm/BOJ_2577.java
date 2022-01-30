package week2;

import java.util.Scanner;

public class BOJ_2577 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
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
