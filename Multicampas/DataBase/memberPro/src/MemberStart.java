import java.util.Scanner;

public class MemberStart {
	Scanner sc = new Scanner(System.in);
	public void start() {
		while(true) {
			menuOutput();
			int menu = Integer.parseInt(sc.nextLine());
			if (menu==1) {
				// �����ͺ��̽����� ȸ������ ��ü�� �����Ͽ� �ֿܼ� ����ϴ� ��ɱ���
				System.out.println(1);
			}else if (menu==2) {
				System.out.println(2);
			}else if (menu==3) {
				System.out.println(3);
			}else if (menu==4) {
				System.out.println(4);
			}else if (menu==5) {
				System.exit(0); // ���α׷��� �����Ű�� �޼ҵ�
			}else {
				System.out.println("�޴��� �߸��Է��Ͽ����ϴ�.");
			}
		}
		
	}
	public void menuOutput() {
		System.out.println("[�޴�]1.ȸ�����, 2.ȸ�����, 3.ȸ������, 4.ȸ������, 5.����?");
	}
	public static void main(String[] args) {
		new MemberStart().start();

	}

}
