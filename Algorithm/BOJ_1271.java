package week1;

import java.util.Scanner;
import java.math.BigInteger;

public class BOJ_1271 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger n = sc.nextBigInteger(); // �Է������� 10�� 1000������ �޼��ϱ� ���� BigInteger ���
		BigInteger m = sc.nextBigInteger(); // int�� �ƴ� ���ڿ� ����� �̷���� �־� ������ ������ �����̴�.
		sc.close();
		
		System.out.println(n.divide(m)); // ������ ��
		System.out.println(n.remainder(m)); // ������ ��
		
//		BigInteger ����
//		���ϱ� : add()
//		��   �� : subtract()
//		���ϱ� : multiply()
//		������ : divide()
//		������ : remainder()
	}
}
