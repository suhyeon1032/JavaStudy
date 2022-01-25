package al03_stack_queue;

import java.util.Scanner;

import al03_stack_queue.IntStack.EmptyIntStackException;
import al03_stack_queue.IntStack.OverflowIntStackException;

public class IntStackMain {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("stack�� ũ���Է� = ");
		int max = s.nextInt();
		
		// ���ð�ü ����
		IntStack stack = new IntStack(max);
		
		while(true) {
			// ���� ������ �����Ͱ����� ������ ũ�⸦ ����ϰ�
			System.out.println("�������� �� -> " + stack.getSize());
			System.out.println(", �޸�ũŰ -> " + stack.getCapacity());
			// �޴����� : push, pop peek, print, search, empty, stack����ǥ��, ����
			System.out.println("[�޴�]1. push, 2.pop, 3.peek, 4.print, 5.search, 6empty, 7.����ǥ��, 8.����");
			int menu = s.nextInt();
			if(menu==8) break;
			// ����, ����, ��� -> ������, char��, String��
			switch(menu) {
			case 1: // ���ÿ� ���� �߰��Ѵ�.
				System.out.println("���ÿ� �߰��� ������: ");
				int data = s.nextInt();
				try {
					int result = stack.push(data);
					System.out.println("���ÿ� ���� ������ : " + result);
				} catch (OverflowIntStackException oise) {
					System.out.println("������ ����á���ϴ�.");
				}
			break;
			case 2: // ���ÿ��� ���� ���´�.
				try {
					int result = stack.pop();
					System.out.println("���ÿ��� " + result + "pop�Ͽ����ϴ�.");
				} catch(EmptyIntStackException e) {
					System.err.println("������ ����ֽ��ϴ�.");
				}
				break;
			case 3: // ���ÿ��� ���� ���� �ִ� ������ ��������
				try {
					int r = stack.peek();
					System.out.println("���� ������ ���� ���� �ִ� ����" + r + "�Դϴ�.");
				}catch(Exception e) {
					System.out.println("������ ����ֽ��ϴ�.");
				}
				break;
			case 4: // ������ ��� ������ ���
				stack.print();
				break;
			case 5: // �˻� : ���� �Է��ϸ� ���� �ִ� index���ϱ�
				System.out.print("�˻��� ������ : ");
				int search = s.nextInt();
				int idx = stack.indexOf(search);
				if (idx>=0) 
					System.out.println(search + "�� ������ " + idx + "��ġ�� �����մϴ�.");
				else
					System.out.println(search + "�� ���ÿ� �����ϴ�.");
				break;
			case 6: // ������ ����ִ��� Ȯ��
				if(stack.isEmpty()) {
					System.out.println("���ÿ� �����Ͱ� ����ֽ��ϴ�.");
				} else {
					System.out.println("���ÿ� �����Ͱ� �ֽ��ϴ�.");
				}
				break;
			case 7: // ��������ǥ��
				System.out.println("������ ũ�� : "+stack.getCapacity());// ������ ũ��
				System.out.println("�������� ���� : "+stack.getSize());// ������ ����
				System.out.println("������ ���� ���� : "+((stack.isEmpty())?"�������":"����������"));// ����ִ��� Ȯ��
				System.out.println("������ Full���� : " + ((stack.isFull())?"������":"����������"));// ����á���� Ȯ��
				
			}
			
			
				
			
				
		}
		System.out.println("���α׷��� ����Ǿ����ϴ�.");
	}

}
