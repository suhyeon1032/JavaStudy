package week20;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_16951 {

	static int N, K, ans;
	static int[] numbers;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		ans = N;
		
		numbers = new int[N];
		
		for(int i = 0 ; i < N ; ++i) numbers[i] = sc.nextInt();

		for(int i = 1 ; i <= 1000 ; ++i) {
			int time = 0;
			for(int j = 0 ; j < N ; ++j) {
				if(i + j * K != numbers[j]) time++;
			}
			ans = ans > time ? time : ans;
		}
		
		System.out.println(ans);
	}

}
