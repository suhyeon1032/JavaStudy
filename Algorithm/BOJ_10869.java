package week1;

import java.util.Scanner;

public class BOJ_10869 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		sc.close();
		
		System.out.println(A+B); // ���ϱ�
		System.out.println(A-B); // ����
		System.out.println(A*B); // ���ϱ�
		System.out.println(A/B); // ��
		System.out.println(A%B); // ������
	}
}