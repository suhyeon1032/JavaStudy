package al04_linkedlist;

import java.util.Scanner;

import al04_linkedlist.LinkedListTest.Node;

public class LinkedListTestMain {
	static Scanner scan = new Scanner(System.in);
	
	//��ȭ�� �̸��� �����Ҽ� �ִ� ����Ŭ����
	static class Data{
		private Integer no;
		private String name;
		
		static final int NO = 1;//��ȣ�� �Է¹����� Ȯ��
		static final int NAME = 2;
		
		//String �������� ���� ��ȯ
		public String toString() {
			return no+" : "+name;
		}
		//��ȣ �Ǵ� �Է¹��� �޼���
		public void scanData(String msg,int s) {
			//s���� 1,2,3�߿� �ϳ��� ��
			if((s & NO) == NO) {
				System.out.print("��ȣ=>");	 //��ȣ�Է�
				no=scan.nextInt();
			}if((s & NAME) ==NAME) {
				System.out.print("�̸�=>");	 //�̸��Է�
				name = scan.next(); //�̸��� ������ ���� �ȵ�. ���� �������� �� �ܾ �Է¹���
			}
		}
	}
	
	//�޴��� ���������� �����
	enum Menu{
		ADD_FIRST("�Ӹ��� ��� ���� "),
		ADD_LAST("������ ��� ���� "),
		REMOVE_FIRST("�Ӹ� ��� ����"),
		REMOVE_CURRENT("������ ��� ���� "),
		DUMP("��� ��� ���  "),
		TERMINATE("����"); 
		
		private final String message;
		
		static Menu MenuAt(int idx) {
			for (Menu m:Menu.values()) {
				if(m.ordinal()==idx)
					return m;
			}
			return null;
		}
		Menu(String str) {
			message = str;
		}
		String getMessage() {
			return message;
		}
	}
	//�޴��� ǥ���ϰ� �޴��� index�� �Է¹޾� ������ �޴���ü �����ϴ� �޼ҵ�
	static Menu SelectMenu() {
		int key;
		do {
			for(Menu m:Menu.values()) {
				System.out.printf("(%d) %s",m.ordinal()+1,m.getMessage());
				if((m.ordinal()+1)%3==0) {
					System.out.println();
				}
			}
			System.out.print("-> �޴� ��ȣ �Է� : ");
			key = scan.nextInt()-1;
		}while(key<Menu.ADD_FIRST.ordinal() || key>Menu.TERMINATE.ordinal());
	
		return Menu.MenuAt(key);
	}
	
	
	public static void main(String[] args) {
		Menu menu;
		LinkedListTest<Data> list = new LinkedListTest<Data>();
	
		do {
			//�޴��� ǥ��
			menu = SelectMenu();
			Data data = new Data();
			switch(menu) {
			case ADD_FIRST://1.�Ӹ��� ��� ����
				data.scanData("�Ӹ���� ����",Data.NO | Data.NAME);
				list.addFirst(data);//List��
				break;
			case ADD_LAST://2.������ ��� ����
				data.scanData("������� ����", Data.NO | Data.NAME);
				list.addLast(data);
				break;
			case REMOVE_FIRST://3.�Ӹ���� ����
				list.removeFirst();
				break;
			case REMOVE_CURRENT://4.���� ��� ����
				list.removeCurrent();
				break;
			case DUMP://5.����� ���
				list.dump();
				break;
			}
		}while(menu !=Menu.TERMINATE);//6.���α׷� ����
		System.out.println("���α׷��� ����Ǿ����ϴ�.");
	}
}