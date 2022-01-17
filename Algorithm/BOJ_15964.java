package week1;

import java.util.Scanner;

public class BOJ_15964 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextInt();
		long B = sc.nextInt();
		// int형보다 큰 값 출력을 위해 long형을 사용
		sc.close();
		
		long sum = (A+B)*(A-B);
		System.out.println(sum);
	}
}
