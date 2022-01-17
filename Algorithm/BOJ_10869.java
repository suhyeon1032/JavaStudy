package week1;

import java.util.Scanner;

public class BOJ_10869 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		sc.close();
		
		System.out.println(A+B); // ´õÇÏ±â
		System.out.println(A-B); // »©±â
		System.out.println(A*B); // °öÇÏ±â
		System.out.println(A/B); // ¸ò
		System.out.println(A%B); // ³ª¸ÓÁö
	}
}