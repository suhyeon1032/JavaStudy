package week1;

import java.util.Scanner;

public class BOJ_5554 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt(); // ������ �б������� �̵� �ð�
		int B = sc.nextInt(); // �б����� PC������� �̵� �ð�
		int C = sc.nextInt(); // PC�濡�� �п������� �̵� �ð�
		int D = sc.nextInt(); // �п����� �������� �̵� �ð�
		sc.close();
		
		int sum = A+B+C+D;
		System.out.println(sum/60); // �ʿ��� 60�� ���� ���� ��
		System.out.println(sum%60); // �ʿ��� 60�� ������ ������ ��
		
	}
}
