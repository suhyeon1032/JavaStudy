package week1;

import java.util.Scanner;

public class BOJ_10869 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		sc.close();
		
		System.out.println(A+B); // 더하기
		System.out.println(A-B); // 빼기
		System.out.println(A*B); // 곱하기
		System.out.println(A/B); // 몫
		System.out.println(A%B); // 나머지
	}
}