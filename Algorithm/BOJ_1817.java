package week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1817 {

	public static void main(String[] args) throws IOException {
		// 짐 챙기는 숌
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N= Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		if(N == 0){
            System.out.println(0);
            return;
        }
		int book[] = new int[N];
		int result = 0;
		int sum = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			book[i] = Integer.parseInt(st.nextToken());
			sum += book[i];
			if(sum > M) {
				result ++; 
				sum = book[i];
			} 
		}
		System.out.println(result);
	}

}
