package al01_basic;

public class Main02_random {
/*
1. 1~100������ ������ 50����� ���� ���϶�.
2. �� �ٿ� 6���� ������ ����ϰ�
3. ������ �ٿ� ���� ����Ѵ�.

����
15 65 19 54 95 24
69 25 31 69 42 26
 2 8  25 62 95 32
 :
 :
 :
 40 65
 �� = 7484
*/

	public static void main(String[] args) {
		int sum = 0;
		for(int a=0; a<50; a++) {
			int n = (int)(Math.random()*100+1);
			sum += n;
			System.out.printf("%2d ", n);
			if((a+1)%6==0) {
				System.out.println();
			}
		}
		System.out.println("��="+sum);
	}


}


