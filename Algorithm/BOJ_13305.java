package week20;

import java.util.Scanner;

public class BOJ_13305 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		long[] dist = new long[N-1];
		long[] cost = new long[N];
		
		for(int i=0; i<N-1; i++) {
			dist[i] = sc.nextLong();
			cost[i] = sc.nextLong();
		}
		
		long sum = 0;
		long minCost = cost[0];
		
		for(int i=0; i<N-1; i++) {
			if(cost[i] < minCost) {
				minCost = cost[i];
			}
			
			sum += (minCost * dist[i]);
		}
		System.out.println(sum);
		sc.close();
	}
}
