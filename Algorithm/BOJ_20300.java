package week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long arr[] = new long[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(arr);
		long M = 0;
		if (N % 2 == 0) {
			for (int i = 0; i < N / 2 + 1; i++) {
				if (M < arr[i] + arr[N - i - 1])
					M = arr[i] + arr[N - i - 1];
			}

		} else {
			if(N==1) {
				M = arr[0];
			} else {
				for(int i=0; i<N/2; i++) {
					if(M < arr[i]+arr[N-i-2])
						M = arr[i]+arr[N-i-2];
				}
			}
			
		}
		
		System.out.println(M);
	}

}
