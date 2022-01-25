package al02_search;

import java.util.Scanner;

public class BinarySearch {
	// ���� �˻�(BinarySearch)
	// �����Ͱ� ���ĵǾ� �־�� �Ѵ�.
	// ��� ��ġ�� ���Ͽ� �˻��Ѵ�.
	static int binarySearch(int arr[], int n, int key) { // �� ������ �� �޼ҵ尡 ȣ��Ǹ� �����Ǵ� ����
		int left = 0; // ���� ���� index
		int rigth = n-1; // ������ ������ index
		
		do {
			// �߰� index�� ���Ѵ�.
			int center = (left+rigth)/2;
			if(key == arr[center]) {
				return center; // �˻��� ���� �߰� index�� ���� ���
			} else if(arr[center] < key) {
				left = center+1; // left�� center+1�� �ٲ۴�.
			} else {
				rigth = center-1;
			}
			
		} while(left<=rigth);
		// �˻��� ���� ���� ���
		return -1;
	}
	
	public static void main(String[] args) { // �� �ȿ� arr, n, key�� main �ȿ��� ������ ����
		Scanner s = new Scanner(System.in);
		
		System.out.println("������ �� = ");
		int n = s.nextInt();
		
		int arr[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			System.out.println("arr["+i+"]=");
			arr[i] = s.nextInt();
		}
		
		// �˻��� �� �Է�
		int key = s.nextInt();
		
		// ���� �˻�
		int result = binarySearch(arr, n, key);
		if (result>=0) {
			System.out.println(key+"�� arr["+result+"]��ġ�� �ֽ��ϴ�.");
		} else {
			System.out.println(key + "�� �������� �ʴ� �������Դϴ�.");
		}
		
	}
}
