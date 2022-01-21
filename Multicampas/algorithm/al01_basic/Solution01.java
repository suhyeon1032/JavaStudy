package al01_basic;

import java.util.Scanner;

public class Solution01 {
	/*
	 ½ÇÇà
	 5
	 5*2=10
	 :
	 :
	 5*9=45
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dan = sc.nextInt();
		for(int i = 2; i<=9; i++) {
			int r = dan*i;
			System.out.printf("%2d * %2d = %3d\n", dan, i, r);
		}
		
		
	

	}

}
