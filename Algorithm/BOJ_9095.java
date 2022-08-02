package week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095 {
	static int T, N[], dp[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		N = new int[T];
		dp = new int[12];
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		dp[4] = 7;
		
		for(int i=0; i<T; i++) {
			N[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0; i<T; i++) {
			
			System.out.println(dynamic(N[i]));
		}
	}
	public static int dynamic(int i) {
		for(int j=5; j<12; j++) {
			dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
		}
		
		if(dp[i] != 0) {
			return dp[i];
		} else {
			return dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
	}

}
