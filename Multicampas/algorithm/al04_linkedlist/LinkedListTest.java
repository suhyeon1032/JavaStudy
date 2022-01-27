package al04_linkedlist;

public class LinkedListTest<E> {
	//���Ŭ����
	class Node<E>{
		private E data;
		private Node<E> next;//���ʳ��
		Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}
	}
	//
	public LinkedListTest() {
		//head,current�� �ʱ�ȭ
		head = null;
		current = null;
	}
	
	//�Ӹ���带 ���� �� ����
	private Node<E> head;
	private Node<E> current;
	
	//1.�Ӹ��� ��� ����
	public void addFirst(E data) {
		//���� ���� ���
		Node<E> point = head;
		head = current = new Node<E>(data, point);
	}
	//2.������ ��� ����
	public void addLast(E data) {
		if(head == null) {//����� ����Ʈ�� ������ -> ��忡 ��� ����
			addFirst(data);
		}else {//����� ����Ʈ�� ������
			Node<E> point = head;
			while(point.next!= null) {
				point = point.next; //next�� �ִ� ��� �Ѿ
			}
			//point�� next�� null�� ���(��, ���� ��尡 ���� ������ ���)
			current = point.next = new Node<E>(data,null);
		}
	}
	//3.�Ӹ� ��� ����
	public void removeFirst() {
		if(head!=null) {//��尡 �����ϸ�
			current = head = head.next;
		}
	}
	//4.���� ��� ����
	public void removeCurrent() {
		remove(current);
	}
	//4-1.��� ����
	public void remove(Node<E> delNode) {
		if(head != null) {//��尡 �����ϸ�
			if(head==delNode) {//������ ��尡 ������
				removeFirst(); //����� ���� �޼��� ����ϰ�		
			}else {
				Node<E> point = head;
				while(point.next != delNode) {//delNode�� �� ��� ã��
					point=point.next;
				}
				//point�� delNode�� �������
				point.next = delNode.next;
				current = point;
			}
		}
		
	}
	//5.��� ��� ���
	public void dump() {
		Node<E> point = head;
			while(point !=null) {
			System.out.println(point.data);
			point = point.next;
		}
	}
}