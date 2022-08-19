package week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1166 {
	static long N, L, W, H, box;
	public static void main(String[] args) throws IOException {
		//선물
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Long.parseLong(st.nextToken());
		L = Long.parseLong(st.nextToken());
		W = Long.parseLong(st.nextToken());
		H = Long.parseLong(st.nextToken());
		
		double low = 0;
		double high;
		
		high = Math.max(L, Math.max(W, H));
		for(int i=0; i<1000; i++) {
			double mid = (low + high)/2;
			if((long)(L/mid) * (long)(W/mid) * (long)(H/mid) >= N) low = mid;
			else high = mid;
		}
		System.out.println(low);
	}
}
