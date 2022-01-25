package al03_stack_queue;

import java.util.Scanner;

public class IntQueueMain {
	static Scanner s = new Scanner(System.in);
	// 메뉴를 입력받는 메소드
	static String getMenu() {
		// 3. 제일 앞의 값을 구하여 출력
		// 4. 큐의 크기, 데이터의 수, front 인덱스, rear 인덱스, 처음 값, 마지막 값을 구하라
		
		System.out.print("[메뉴]1. enqueue, 2. dequeue, 3. peek, 4.info, 9. end ?");
		return s.nextLine();
	}

	public static void main(String[] args) {

		IntQueue queue = new IntQueue(4);
		
		while(true) {
			String menu = getMenu();
			if (menu.equals("9")) { // 1. end 선택시
				break;
			}else { // 그 외 메뉴선택시
				switch(menu) {
				case "1": // 큐에 데이터를 추가한다.
					System.out.println("큐에 추가할 데이터 -> ");
					int data = Integer.parseInt(s.nextLine());
					try {
						int result = queue.enqueue(data);
					} catch(Exception e) {
						System.out.println("큐가 가득 찼습니다.");
					}
					break;
				case "2": // 큐의 데이터 가져오기(제일앞에)
					try {
						int result = queue.dequeue();
						System.out.println("큐에서 가져온 데이터 -> "+result);
					}catch (Exception e) {
						System.out.println("큐가 비어 있습니다.");
					}
					break;
				case "3": // 제일 앞에 있는 객체 얻어오기
					try {
						int result = queue.peek();
						System.out.println("현재 큐의 제일 앞 데이터 -> " + result);
					} catch(Exception e) {
						System.out.println("큐가 비어 있습니다.");
					}
					break;
					
				case "4": // 4. 큐의 크기, 데이터의 수, front 인덱스, rear 인덱스(rear-1해줘야함), 처음 값, 마지막 값을 구하라
					System.out.println("큐의 크기 -> " + queue.getCapacity());
					System.out.println("데이터의 수 -> " + queue.getSize());
					System.out.println("front 인덱스 -> " + queue.getFrontIndex());
					System.out.println("rear 인덱스 -> " + queue.getRearIndex());
					System.out.println("처음 값 -> " + queue.peek());
					System.out.println("마지막 값 -> " + queue.getRearData());
					break;
					
				
				default:
					System.out.println("메뉴를 잘못 선택하였습니다.");
				}
			}
		}
		System.out.println("프로그램이 종료되었습니다.");

	}

}
