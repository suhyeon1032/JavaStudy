package week20;

import java.util.Scanner;

public class BOJ_9655 {

	public static void main(String[] args) {
		// 돌 게임
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		if(N%2 == 0) System.out.println("CY");
		else System.out.println("SK");
		
		sc.close();
	}

}
