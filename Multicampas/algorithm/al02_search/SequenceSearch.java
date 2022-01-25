package al02_search;

import java.util.Scanner;

public class SequenceSearch {
	// for���� �̿��Ͽ� �˻��ϱ�
	// key�� ���� �ִ� ��ġ�� ���Ͽ� index�� ��ȯ�ϴ� �޼ҵ�
	// 						������ ��� �迭, �����ͼ�, �˻��� �� // �̰��� �������� ���°�� �ִ��� �˻��ؼ� �������ְڴ�.
	static int linearSearch1(int[] data, int n, int key) { // �˻��۾��� ���⼭ �� ��ġ�� �˷��ְ� �� ���� �۾��� int�� ���ϵż� int idx = linearSearch1(); ����� �̵��Ѵ�.
		// �迭���� key���� �˻��Ͽ� index�� �����Ѵ�.
		// ���� �˻��� index�� ������ -1�� �����Ѵ�.
		for(int i=0; i<n; i++) { // 0, 1, 2, 3, ...
			if(data[i]==key) {
				return i;
			}
		}
		
		return -1;
	}
	
	// while���� �̿��� ��������ġ �˻�
	static int linearSearch2(int[] d, int n, int k) {
		int i = 0;
		while(true) {
			if(i==n) { // i index��ġ�� �����ϴ°�
				return -1;
			}
			if(d[i] == k) { // �˻��� �����͸� ã�� ���
				return i;
			}
			// ���� index�� ���� Ȯ���ϱ� ���ؼ� index�� 1����
			++i; // ++i, i++, i=i+1, i+=1 �� ��밡��
		}
		
	}

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		// �������� ���� �Է� : �迭�� ����
		System.out.println("������ �� ->");
		int n = s.nextInt();
		
		// �迭�� ����
		int data[] = new int[n];
		
		// ������ �Է�
		for(int i=0; i<n; i++) {
			System.out.println("data["+i+"]=");
			data[i] = s.nextInt();
		}
		
		// ã�� ���ڸ� �Է¹޴´�.
		System.out.println("�˻��� ������ ->");
		int key = s.nextInt();

		// for�� �̿��� �����˻� ȣ��
		int idx = linearSearch1(data, n, key); // n-> data ����, key -> �˻��� �� // -1, 0, 1, 2, 3,... �� �ϳ��� ���� ����
		if(idx>=0) { // �˻��� �����Ͱ� ���� �� // idx-> data, n, key ���� ���� ��
			System.out.println(key + "�� data["+idx+"]�� �ֽ��ϴ�.");
		} else { // �˻��� �����Ͱ� ���� �� (-1)
			System.out.println(key + "�� �������� �ʴ� �������Դϴ�.");
		}
		// while���� �̿��� �����˻� ȣ��
		int idx2 = linearSearch2(data, n, key);
		if (idx2 >= 0) { // �˻��� �����Ͱ� �����Ѵ�.
			System.out.println(key + "�� data["+idx2+"]�� �ֽ��ϴ�.");
		} else { // �˻��� �����Ͱ� �������� �ʴ´�.
			System.out.println(key + "�� �������� �ʴ� �������Դϴ�.");
		}
		
	}

}
