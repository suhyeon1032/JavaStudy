import java.util.Scanner;

public class MemberStart {
	Scanner sc = new Scanner(System.in);
	public void start() {
		while(true) {
			menuOutput();
			int menu = Integer.parseInt(sc.nextLine());
			if (menu==1) {
				// 데이터베이스에서 회원정보 전체를 선택하여 콘솔에 출력하는 기능구현
				System.out.println(1);
			}else if (menu==2) {
				System.out.println(2);
			}else if (menu==3) {
				System.out.println(3);
			}else if (menu==4) {
				System.out.println(4);
			}else if (menu==5) {
				System.exit(0); // 프로그램을 종료시키는 메소드
			}else {
				System.out.println("메뉴를 잘못입력하였습니다.");
			}
		}
		
	}
	public void menuOutput() {
		System.out.println("[메뉴]1.회원목록, 2.회원등록, 3.회원수정, 4.회원삭제, 5.종료?");
	}
	public static void main(String[] args) {
		new MemberStart().start();

	}

}
