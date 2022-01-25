package al03_stack_queue;

public class IntQueue {
	int capacity; //ť�� ũ��
	int queue[]; // ť�� �޸𸮸� ����
	
	// ����:0, �Ǽ�:0.0, ��:false, ��ü��:null �� �ʱⰪ
	int front; // ���� �� ��ġ
	int rear; // ������ ��ġ
	int dataCnt; // queue�� ������ ����
	
	
	public IntQueue() {}
	public IntQueue(int capcity) {
		this.capacity = capcity;
		queue = new int[capcity];
		
//		front = 0;
//		rear = 0;
//		dataCnt = 0;
//		
//		front=rear=dataCnt=0; //�ΰ��� ��� �� ��밡�������� ������ �����ϴ�.
	}
	// ť�� �����͸� �߰��ϴ� �޼ҵ�
	public int enqueue(int data) throws QueueOverFlowException { 
		// �����Ͱ� ���� á���� Ȯ��
		// capacity: �뷮, dataCnt: ����  ������ ��
		if(capacity <= dataCnt) { // �����÷ο� �߻�
			throw new QueueOverFlowException();
		}
		// �����͸� ť�� ��´� (rear:��ġ��)
		
		queue[rear++] = data;
		dataCnt++; // �������� �� ���� // �ܵ� ���� �������� ��쿣 dataCnt++, ++dataCnt �� ��밡��
		// rear��ġ�� �������� ó���ϱ�
		if(rear == capacity) {
			rear = 0;
		}
		System.out.println("rear ->" + rear + ", ���� ������ = "+ dataCnt);
		
		return data;
		
	}
	// ť���� �����͸� ������ �޼ҵ�
	public int dequeue() throws QueueEmptyException{
		if(dataCnt<=0) {
			throw new QueueEmptyException();
		}
		// ť�� �����Ͱ� ������ �����
		dataCnt--; // ���� ��ü�� ���� 1����
		int deData = queue[front++];
		if(front == capacity)
			front = 0;
		System.out.println("front -> " + front + ", ���� �����ͼ� = "+ dataCnt);
		return deData;
	}
	// ť�� ���� ��(front) �����͸� ���Ѵ�
	public int peek() throws QueueEmptyException{
		if(dataCnt <= 0) {
			throw new QueueEmptyException();
		}
		return queue[front];
	}
	// ť�� ũ��
	public int getCapacity() {
		return capacity;
	}
	// ť�� ������ ��
	public int getSize() {
		return dataCnt;
	}
	// front Index
	public int getFrontIndex() {
		return front;
	}
	public int getRearIndex() {
		return rear;
	}
	// ������ ��
	public int getRearData() {
		return queue[rear-1];
	}
	// ť�� ��������� Empty ���� Ŭ����
	class QueueEmptyException extends RuntimeException {
		QueueEmptyException() {};
	}
	// �����÷ο� �߻��� ó���� ����
	class QueueOverFlowException extends RuntimeException {
		QueueOverFlowException(){}
	}
}
