package al01_basic;

import java.util.Scanner;

public class Main01 {
	/*
	 1��. �Է¹��� �⵵�� ����
	 
	 ����
	 6
	 4 100 400 2000 2001 2004
	 [���]
	 #1 ���� 
	 #2 ���
	 #3 ����
	 #4 ����
	 #5 ���
	 #6 ����
	 
	 */
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = Integer.parseInt(sc.nextLine());
		String data[] = sc.nextLine().split(" ");
		String r[] = new String[n];
		for(int i= 0; i<n; i++) { // 0, 1, 2, 3, 4
			// 4�⸶�� ����(�� 100���� �������� �ʴ� ��), 400�⸶�� ����
			int y = Integer.parseInt(data[i]);
			if(y%4==0 && y%100!=0 || y%400==0) { // ����
				r[i] = "����";
			}else { // ���
				r[i] = "���";
			}
			
		}
		sc.close();
		// ���
		for(int i=1;i<=n;i++) {// 1,2,3,4,5,6
			System.out.println("#"+i+" "+r[i-1]);
		}

	}
	


}
