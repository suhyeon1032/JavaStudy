package week20;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ_14467 {
	static int N,cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		int[][] cow = new int[N][2];
		
		for(int i=0; i<N; i++) {
			cow[i][0] = sc.nextInt();
			cow[i][1] = sc.nextInt();
		}
		
		Arrays.sort(cow, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		
		for(int i=0; i<N; i++) {
			System.out.println(cow[i][0] + " " + cow[i][1]);
		}
		
		int num = cow[0][0]; // 소 번호
		int sts = cow[0][1]; // 소 위치
		for(int i=1; i<N; i++) {
			int now = cow[i][0]; // 현재 소 번호
			
			if(now == num) 
				if(sts != cow[i][1]) 
					cnt++;
			
			sts = cow[i][1];
			num = now;
		}
		sc.close();
		System.out.println(cnt);
	}
}
