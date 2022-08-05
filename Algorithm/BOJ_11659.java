package week20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11659 {
	static int N, M, firstNum, lastNum;
	static long num[], sum[];
	public static void main(String[] args) throws IOException {
		// 구간 합 구하기 4
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new long[N+1]; 
		sum = new long[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			num[i] = Long.parseLong(st.nextToken());
			
			if(i == 1) {
				sum[i] = num[i];
			} else {
				sum[i] = sum[i-1] + num[i];
			}
		}
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			firstNum = Integer.parseInt(st.nextToken());
			lastNum = Integer.parseInt(st.nextToken());
			
			if(firstNum == 1) {
				bw.write(sum[lastNum] + "\n");
			} else {
				bw.write(sum[lastNum] - sum[firstNum-1] + "\n");
			}
		}
		br.close();
        bw.close();
	}

}
