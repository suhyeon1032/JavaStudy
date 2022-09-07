package week20;

import java.util.Scanner;

public class BOJ_9461 {

	public static void main(String[] args) {
		// 파도반 수열
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		long[] dp = new long[101];
		
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;
		dp[4] = 2;
		
		for(int i=5; i<=100; i++) {
			dp[i] = dp[i-5] + dp[i-1];
		}
		while(T-->0) {
			int N = sc.nextInt();
			System.out.println(dp[N-1]);
		}
	}

}
