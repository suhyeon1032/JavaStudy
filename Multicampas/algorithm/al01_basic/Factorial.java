package al01_basic;

import java.util.Scanner;
/*
 ����
 5
 120
 */

public class Factorial {
	// for���� �̿��� ���丮�� ���ϱ�
	static int factorial1(int max) {
		// 5*4*3*2*1
		int result = 1;
		for(int i=max; i>=1; i--) { //5,4,3,2,1
			result *= i;
		}
		return result;
	}
	//2.��ȯ�����Ͱ� ���� ����Լ�
		static int result;
		public static void factorial2(int max) {
			if(max<=1) return;
			result *= max;
			factorial2(max-1);
		}
		
		//3.��ȯ������(���丮���� ���� �����)�� �ִ� ����Լ�
		public static int factorial3(int max) {
			if(max<=1) return 1;
			return max*factorial3(max-1);
		}
		
		//4.while�� ���� ���丮�� ���ϱ�
		public static int factorial4(int max) {
			int r =1;
			while(true) {
				if (max<=1) return r;
				r*=max;
				max--;
			}
		}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		//�Է��� �� ���� ���丮�� ���ϱ�
		int max = s.nextInt();
		
		//1.for���� ���� ���丮�� ����
		int res1 = factorial1(max);
		System.out.println("f1->"+res1);
		
		//2.��ȯ�����Ͱ� ���� ����Լ�
		result =1;
		factorial2(max);
		System.out.println("f2->"+result);
		
		//3.��ȯ������(���丮���� ���� �����)�� �ִ� ����Լ�
		int r = factorial3(max);
		System.out.println("f3->"+r);
		
		//4.while�� ���� ���丮�� ���ϱ�
		int answer = factorial4(max);
		System.out.println("f4->"+answer);
		
		s.close();
	}
}
