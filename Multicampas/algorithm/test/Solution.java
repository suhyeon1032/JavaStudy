package test;

import java.util.Arrays;
import java.util.Scanner;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV13zo1KAAACFAYh
// 1204. [S/W 문제해결 기본] 1일차 - 최빈수 구하기
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// 그룹수
		int cnt = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < cnt; i++) {
			int num = Integer.parseInt(scan.nextLine());
			int[] jumsuCnt = new int[101];
			
			String inStr[] = scan.nextLine().split(" ");
			
			// 문자열 배열을 숫자 배열로 변경한다.
			int inData[] = Arrays.stream(inStr).mapToInt(Integer::parseInt).toArray();
			for(int j = 0; j<inData.length; j++) {
				// j번째 있는 값을 index로 사용하는 카운터한다.
				jumsuCnt[inData[j]] += 1;
			}
			// 제일 큰 값이 들어있는 (index==점수)를 구한다.
			int maxIndex = 0;
			for(int k = 0; k < jumsuCnt.length; k++) {
				if(jumsuCnt[maxIndex] <= jumsuCnt[k]) {
					maxIndex = k;
				}
			}
			System.out.println("#"+ num + " " + maxIndex);
		}
		
	}
}
