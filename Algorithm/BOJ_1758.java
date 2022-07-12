package week20;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_1758 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Integer N = sc.nextInt();
		
		Integer T[] = new Integer[N];
		long sum = 0;
		for(int i=0; i<N; i++) {
			T[i] = sc.nextInt();
		}
		Arrays.sort(T,Collections.reverseOrder());
		for(int i=0; i<N; i++) {
			System.out.println(T[i]);
		}
		for(int i=0; i<N; i++) {
			
			if(T[i]-i > 0) {
				sum += T[i]-i;
			}
		}
		System.out.println(sum);
		sc.close();
	}

}
