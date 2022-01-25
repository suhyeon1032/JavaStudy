package al03_stack_queue;

public class IntQueue {
	int capacity; //큐의 크기
	int queue[]; // 큐의 메모리를 선언
	
	// 정수:0, 실수:0.0, 논리:false, 객체형:null 이 초기값
	int front; // 제일 앞 위치
	int rear; // 마지막 위치
	int dataCnt; // queue의 데이터 개수
	
	
	public IntQueue() {}
	public IntQueue(int capcity) {
		this.capacity = capcity;
		queue = new int[capcity];
		
//		front = 0;
//		rear = 0;
//		dataCnt = 0;
//		
//		front=rear=dataCnt=0; //두가지 방법 다 사용가능하지만 생략도 가능하다.
	}
	// 큐에 데이터를 추가하는 메소드
	public int enqueue(int data) throws QueueOverFlowException { 
		// 데이터가 가득 찼는지 확인
		// capacity: 용량, dataCnt: 현재  데이터 수
		if(capacity <= dataCnt) { // 오버플로우 발생
			throw new QueueOverFlowException();
		}
		// 데이터를 큐에 담는다 (rear:위치에)
		
		queue[rear++] = data;
		dataCnt++; // 데이터의 수 증가 // 단독 증감 연사자일 경우엔 dataCnt++, ++dataCnt 다 사용가능
		// rear위치를 링형으로 처리하기
		if(rear == capacity) {
			rear = 0;
		}
		System.out.println("rear ->" + rear + ", 남은 데이터 = "+ dataCnt);
		
		return data;
		
	}
	// 큐에서 데이터를 얻어오기 메소드
	public int dequeue() throws QueueEmptyException{
		if(dataCnt<=0) {
			throw new QueueEmptyException();
		}
		// 큐에 데이터가 있을때 실행됨
		dataCnt--; // 남은 객체의 수를 1감소
		int deData = queue[front++];
		if(front == capacity)
			front = 0;
		System.out.println("front -> " + front + ", 남은 데이터수 = "+ dataCnt);
		return deData;
	}
	// 큐의 제일 앞(front) 데이터를 구한다
	public int peek() throws QueueEmptyException{
		if(dataCnt <= 0) {
			throw new QueueEmptyException();
		}
		return queue[front];
	}
	// 큐의 크기
	public int getCapacity() {
		return capacity;
	}
	// 큐의 데이터 수
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
	// 마지막 값
	public int getRearData() {
		return queue[rear-1];
	}
	// 큐가 비어있을때 Empty 예외 클래스
	class QueueEmptyException extends RuntimeException {
		QueueEmptyException() {};
	}
	// 오버플로우 발생시 처리할 예외
	class QueueOverFlowException extends RuntimeException {
		QueueOverFlowException(){}
	}
}
