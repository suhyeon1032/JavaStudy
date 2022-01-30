package week1;

import java.util.Scanner;

public class BOJ_3003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[6]; // 입력받는 피스 배열
		int[] piece = new int[] {1,1,2,2,2,8}; // 비교할 올바른 개수
		for (int i = 0; i < 6; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		for (int i = 0; i < 6; i++) {
			arr[i] = piece[i] - arr[i]; // arr에 올바른 개수가 들어간 piece와 비교하여 저장한다
			System.out.println(arr[i]); // 출력한다
		}
	}
}