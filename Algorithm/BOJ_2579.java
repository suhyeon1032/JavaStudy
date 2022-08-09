package week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2579 {

	public static void main(String[] args) throws IOException {
		// 계단 오르기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N+1];
		int dp[] = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		if(N == 1) System.out.println(arr[1]);
		else {
			dp[1] = arr[1];
			dp[2] = arr[1] + arr[2];
			
			for(int i=3; i<=N; i++) {
				dp[i] = arr[i] + Math.max(dp[i-2], arr[i-1] + dp[i-3]);
			}
			System.out.println(dp[N]);
		}
		
		System.out.println(Arrays.toString(dp));
	}

}
