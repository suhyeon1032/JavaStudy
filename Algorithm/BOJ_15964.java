package week1;

import java.util.Scanner;

public class BOJ_15964 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextInt();
		long B = sc.nextInt();
		// int������ ū �� ����� ���� long���� ���
		sc.close();
		
		long sum = (A+B)*(A-B);
		System.out.println(sum);
	}
}
