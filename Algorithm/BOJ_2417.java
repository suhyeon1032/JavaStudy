package week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2417 {
	static long start, result;
	static Long end;
	public static void main(String[] args) throws IOException {
		// 정수 제곱근
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Long N = Long.parseLong(br.readLine());
		
		start = 0; 
		end = N;
		
		while (start <= end) {
			long mid = (start+end) / 2;
			if(Math.pow(mid, 2) >= N) {
				result = mid;
				end = mid -1;
			} else {
				start = mid + 1;
			}
			
		}
		System.out.println(result);
	}

}
