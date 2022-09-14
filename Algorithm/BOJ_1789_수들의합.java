package week20;

import java.util.Scanner;

public class BOJ_1789_수들의합 {

	public static void main(String[] args) {
		// 수들의 합
		Scanner sc = new Scanner(System.in);
		long S = sc.nextLong();

		long sum = 0;
		int cnt = 0;
		for(int i=1; i<S; i++) {
			sum += i;
			cnt++;
			if(S<sum) {
				break;
			}
		}
		if(S == 1) System.out.println(1);
		else System.out.println(cnt-1);
	}

}

