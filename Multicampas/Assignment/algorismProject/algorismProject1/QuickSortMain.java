package algorismProject1;

import java.util.Scanner;

public class QuickSortMain {
	
	//�迭 �� ��ġ ��ȯ �޼���
	public static void swap(int a[],int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	//������ �˰��� �޼���
	public static void myQuick(int a[], int left, int right) {
		int pl = left;  //pointLeft
		int pr = right; //pointRight
		int pivot = a[(left+right)/2];
		
		do {
			//pivot�������� ���ʿ��� ���������� �ǹ��� ������ ū ���� �ε��� ã��
			while(a[pl]<pivot) pl++; //pivot������ ������ �������� �Ѿ
			//pivot�������� �����ʿ��� �������� �ǹ������� ���� ���� �ε��� ã��
			while(a[pr]>pivot) pr--;//pivot������ ũ�� �������� �Ѿ
			
			if(pl<=pr) { //pl��ġ�� ���� pr������ �� ��ȯ
				swap(a,pl++,pr--);
			}
		}while(pl <= pr);
				
		//���� �� ������ �ٽ� �����ϴ� ��� ȣ��
		if(left < pr) {
			myQuick(a, left, pr);
		}
		//���� �� �������� �ٽ� �����ϴ� ��� ȣ��
		if(pl < right) {
			myQuick(a, pl, right);
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("�л� �� �Է� : ");
		int num = scan.nextInt();
		int scores[] = new int[num];
		
		for(int i = 0; i<num; i++) {
			System.out.print("�л� "+(i+1)+" ���� �Է� : ");
			scores[i] = scan.nextInt();
		}
		myQuick(scores,0,scores.length-1);
		
		System.out.println("���� ������ ����");
		for(int i = num-1; i>=0; i--) {
			System.out.println((num-i)+"�� : "+scores[i]);
		}
		scan.close();
	}
}

 