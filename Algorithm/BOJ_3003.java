package week1;

import java.util.Scanner;

public class BOJ_3003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[6]; // �Է¹޴� �ǽ� �迭
		int[] piece = new int[] {1,1,2,2,2,8}; // ���� �ùٸ� ����
		for (int i = 0; i < 6; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		for (int i = 0; i < 6; i++) {
			arr[i] = piece[i] - arr[i]; // arr�� �ùٸ� ������ �� piece�� ��ȭ�� �����Ѵ�
			System.out.println(arr[i]); // ����Ѵ�
		}
	}
}
