package week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726 {
	static int n, dp[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		dp = new int[n+2];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 3;
		dp[4] = 5;
		dp[5] = 8; // 6->13 7->21 8->34 8->55
		
		for(int i=6; i<=n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[n]%10007);
	}

}
