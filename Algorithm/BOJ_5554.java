package week1;

import java.util.Scanner;

public class BOJ_5554 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(); // 집에서 학교까지의 이동 시간
		int B = sc.nextInt(); // 학교에서 PC방까지의 이동 시간
		int C = sc.nextInt(); // PC방에서 학원까지의 이동 시간
		int D = sc.nextInt(); // 학원에서 집까지의 이동 시간
		sc.close();
		
		int sum = A+B+C+D;
		System.out.println(sum/60); // 초에서 60을 나눠 나온 분
		System.out.println(sum%60); // 초에서 60을 나누고 나머지 초
		
	}
}