package week1;

import java.util.Scanner;

public class BOJ_17496 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // ���� �� ��
		int T = sc.nextInt(); // ��Ÿ�ĸ��� �ڶ�µ� �ɸ��� �� ��
		int C = sc.nextInt(); // ��Ÿ�帣�� ���� ĭ ��
		int P = sc.nextInt(); // ��Ÿ�ĸ��� ���� ����
		
		System.out.println((N-1) / T * C * P);
		// N-1 : �ɰ� +1�� ���� ��Ȯ �����ϱ� ������ -1 ���ش�.
	}
}
