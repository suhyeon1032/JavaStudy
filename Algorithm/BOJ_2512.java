package week20;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2512 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int num[] = new int[N];
		
		for(int i=0; i<N; i++) {
			num[i] = sc.nextInt();
		}
		Arrays.sort(num);
		
		long max = sc.nextLong();
		
		long start = 0;
		long end = num[N-1];
		long ans = 0;
		
		while(start <= end) {
			long middle = (start + end) / 2;
			long sum = 0;
			for(int i=0; i<N; i++) {
				if(num[i] >= middle) {
					sum += middle;
				}else {
					sum += num[i];
				}
			}
			if(sum > max) {
				end = middle - 1;
			}else {
				start = middle + 1;
			    ans = Math.max(middle, ans);
			}
		    
		}
		System.out.println(ans);
	}
}
