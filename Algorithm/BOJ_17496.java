package week1;

import java.util.Scanner;

public class BOJ_17496 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 여름 일 수
		int T = sc.nextInt(); // 스타후르츠 자라는데 걸리는 일 수
		int C = sc.nextInt(); // 스타흐르츠 심을 칸 수
		int P = sc.nextInt(); // 스타후르츠 개당 가격
		
		System.out.println((N-1) / T * C * P);
		// N-1 : 심고 +1일 부터 수확 가능하기 때문에 -1 해준다.
	}
}