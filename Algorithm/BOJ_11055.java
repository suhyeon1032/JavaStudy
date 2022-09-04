package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11055 {

	public static void main(String[] args) throws IOException {
		// 가장 큰 증가 부분 수열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int arr[] = new int[A+1];
		int dp[] = new int[A+1];
		for(int i=0; i<A; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = arr[0];
		
		for(int i=1; i<=A; i++) {
			dp[i] = arr[i];
			for(int j=0; j<i; j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[j]+arr[i], dp[i]);
				}
			}
		}
		int max = Integer.MIN_VALUE;
			for(int i=0; i<=A; i++) {
				if(dp[i] > max) max = dp[i];
			}
		System.out.println(max);

	}

}
