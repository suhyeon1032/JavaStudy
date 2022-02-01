package algorismProject2;

import java.util.Scanner;

public class BinarySearchTreeMain {

	static Scanner s = new Scanner(System.in);
	
	//	데이터를 담을 객체
	static class Data{
		
		private int no;				//	입력받은 번호
		private String name;		//	입력받은 이름
		
		
		//
		static final int NO = 1;			//	번호 입력 받을 지 화인
		static final int NAME = 2;			//	이름 입력 받을 지 확인
		
		
		//	번호를 얻을 수 있는 메소드
		Integer getKeyCode() {
			return no;
		}
		//	이름얻을 수 있는 메소드
		public String toString() {
			return name;
		}
		
		
		//	데이터 입력받는 메소드
		public void inData(String msg, int sw) {
//			System.out.println("상품 등록");
			
			if((sw&NO) == NO) {
				System.out.print("상품 번호 : ");
				no = Integer.parseInt(s.nextLine());
			}
			if((sw&NAME) == NAME) {
				System.out.print("상품명 : ");
				name = s.nextLine();
			}
			System.out.println();
		}	
	}//	Data
	
	//	Menu
	enum Menu{
		ADD("상품 정보"),
		REMOVE("상품 삭제"),
		SEARCH("상품 검색"),
		PRINT("전체 상품 조회"),
		TERMINATE("종료");
		private final String message;
		
		Menu(String msg){
			message = msg;
		}
		
		String getMessage() {
			return message;
		}
		
		//	사용자가 입력한 메뉴객체를 리턴하는 메소드
		static Menu menuAt(int idx) {
			for(Menu m : Menu.values()) {
				if(m.ordinal() == idx) {
					return m;
				}
			}
			return null;
		}
	}//	Menu
	//	메뉴 출력하고 사용자에게 메뉴를 입력받은 메소드
	//	    반환형 : 선택한 메뉴 객체
	static Menu selectMenu() {
		int menuNo;
		do {	//	메뉴를 잘못 입력하면 다시 입력받기 위해서 반복을 실행한다.
			for(Menu m : Menu.values()) {	//	메뉴출력
				System.out.printf("(%d) %s  ",m.ordinal()+1, m.getMessage());
			}
			System.out.println();
			System.out.print("메뉴 선택 : ");
			menuNo = Integer.parseInt(s.nextLine())-1;	//	정수로 리턴
		}while(menuNo < Menu.ADD.ordinal() || menuNo > Menu.TERMINATE.ordinal());
		return Menu.menuAt(menuNo);	
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Menu m;
		
		///
		BinaryTree<Integer, Data> tree = new BinaryTree<Integer, Data>();
		Data data;
		///
		
		do {
			m = selectMenu();		//	사용자가 선택한 메뉴
			switch (m) {
			case ADD:				//	번호, 이름을 입력받아 Node에 넣고 tree에 저장
				System.out.println("상품 등록");
				data = new Data();
				data.inData("회원정보", data.NO | data.NAME);
				//	새로운 노드 추가하기
				tree.add(data.getKeyCode(), data);
				break;
				
			case REMOVE:
				System.out.println("상품 삭제");
				//	삭제할 키를 입력받기
				data = new Data();
				data.inData("삭제할 key", data.NO);
				boolean result = tree.remove(data.getKeyCode());
				////////
				if(result)
					System.out.println("상품 삭제 완료");
				else
					System.out.println("등록된 상품이 없습니다.");
				break;
			
			case SEARCH:
				System.out.println("상품 검색");
				data = new Data();
				data.inData("검색할 key", data.NO);	//	key가 저장됨
				//	검색한 결과를리턴받는다.
				Data searchData = tree.search(data.getKeyCode());
				if(searchData == null) {
					System.out.println("등록된 상품이 없습니다.");
				}else {	//	검색 결과가 있을 때
					System.out.println("상품명 : "+searchData);
				}
				break;
				
			case PRINT:
				tree.print();
				System.out.println();
				break;
		
			}
		}while(m != Menu.TERMINATE);
		System.out.println("종료합니다.");
		//	프로그램 종료됨
	}

}


