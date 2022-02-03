package test;

import java.util.Arrays;
import java.util.Scanner;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV13zo1KAAACFAYh
// 1204. [S/W �����ذ� �⺻] 1���� - �ֺ�� ���ϱ�
public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		// �׷��
		int cnt = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < cnt; i++) {
			int num = Integer.parseInt(scan.nextLine());
			int[] jumsuCnt = new int[101];
			
			String inStr[] = scan.nextLine().split(" ");
			
			// ���ڿ� �迭�� ���� �迭�� �����Ѵ�.
			int inData[] = Arrays.stream(inStr).mapToInt(Integer::parseInt).toArray();
			for(int j = 0; j<inData.length; j++) {
				// j��° �ִ� ���� index�� ����ϴ� ī�����Ѵ�.
				jumsuCnt[inData[j]] += 1;
			}
			// ���� ū ���� ����ִ� (index==����)�� ���Ѵ�.
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