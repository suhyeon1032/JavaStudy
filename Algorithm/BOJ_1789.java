package Baekjoon;

import java.util.Scanner;

public class BOJ_1789 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long S = sc.nextLong();
		long sum = 0;
		long cnt = 0;
		
		for(int i=1; i<=S; i++) {
			sum += i;
			cnt++;
			if(S<sum) {
				break;
			}
		}
		if(S==1) System.out.println(1);
		else System.out.println(cnt-1);
	}

}
