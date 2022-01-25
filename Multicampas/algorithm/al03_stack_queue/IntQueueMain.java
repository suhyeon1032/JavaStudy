package al03_stack_queue;

import java.util.Scanner;

public class IntQueueMain {
	static Scanner s = new Scanner(System.in);
	// �޴��� �Է¹޴� �޼ҵ�
	static String getMenu() {
		// 3. ���� ���� ���� ���Ͽ� ���
		// 4. ť�� ũ��, �������� ��, front �ε���, rear �ε���, ó�� ��, ������ ���� ���϶�
		
		System.out.print("[�޴�]1. enqueue, 2. dequeue, 3. peek, 4.info, 9. end ?");
		return s.nextLine();
	}

	public static void main(String[] args) {

		IntQueue queue = new IntQueue(4);
		
		while(true) {
			String menu = getMenu();
			if (menu.equals("9")) { // 1. end ���ý�
				break;
			}else { // �� �� �޴����ý�
				switch(menu) {
				case "1": // ť�� �����͸� �߰��Ѵ�.
					System.out.println("ť�� �߰��� ������ -> ");
					int data = Integer.parseInt(s.nextLine());
					try {
						int result = queue.enqueue(data);
					} catch(Exception e) {
						System.out.println("ť�� ���� á���ϴ�.");
					}
					break;
				case "2": // ť�� ������ ��������(���Ͼտ�)
					try {
						int result = queue.dequeue();
						System.out.println("ť���� ������ ������ -> "+result);
					}catch (Exception e) {
						System.out.println("ť�� ��� �ֽ��ϴ�.");
					}
					break;
				case "3": // ���� �տ� �ִ� ��ü ������
					try {
						int result = queue.peek();
						System.out.println("���� ť�� ���� �� ������ -> " + result);
					} catch(Exception e) {
						System.out.println("ť�� ��� �ֽ��ϴ�.");
					}
					break;
					
				case "4": // 4. ť�� ũ��, �������� ��, front �ε���, rear �ε���(rear-1�������), ó�� ��, ������ ���� ���϶�
					System.out.println("ť�� ũ�� -> " + queue.getCapacity());
					System.out.println("�������� �� -> " + queue.getSize());
					System.out.println("front �ε��� -> " + queue.getFrontIndex());
					System.out.println("rear �ε��� -> " + queue.getRearIndex());
					System.out.println("ó�� �� -> " + queue.peek());
					System.out.println("������ �� -> " + queue.getRearData());
					break;
					
				
				default:
					System.out.println("�޴��� �߸� �����Ͽ����ϴ�.");
				}
			}
		}
		System.out.println("���α׷��� ����Ǿ����ϴ�.");

	}

}
