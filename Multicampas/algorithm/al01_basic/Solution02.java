package al01_basic;

import java.util.Scanner;

public class Solution02 {
	static String name = "È«±æµ¿";
	/*
	 ½ÇÇà
	 3
	 3 * 2 =
	 :
	 :
	 3 * 9 = 27
	 */
	public static void gugudan(int dan) {
		for(int i = 2; i <= 9; i++) {
			int r = dan * i;
			System.out.printf("%2d * %2d = %3d\n", dan, i, r);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dan = sc.nextInt();
		gugudan(dan);
		sc.close();
		
	}
	

}


