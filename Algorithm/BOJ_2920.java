package week2;


import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2920 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] n = new int[8];
		int[] arrA = {1,2,3,4,5,6,7,8};
		int[] arrD = {8,7,6,5,4,3,2,1};
		
		
		for (int i = 0; i < n.length; i++) {
			n[i] = sc.nextInt();
		}
		sc.close();
		
		
		if (Arrays.equals(arrA, n)) {
			System.out.println("ascending");
		} else if (Arrays.equals(arrD, n)) {
			System.out.println("descending");
		} else {
			System.out.println("mixed");
		}
		// 두 배열을 비교하기 위해 Arrays.equals 사용
	}

}
