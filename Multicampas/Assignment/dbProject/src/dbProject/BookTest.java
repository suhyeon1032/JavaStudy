package dbProject;

import java.util.Scanner;

public class BookTest {
	Scanner sc = new Scanner(System.in);
	public void start() {
		while(true) {
			Output();
			int menu = Integer.parseInt(sc.nextLine());
			
			if (menu == 1) {
				insertBook();
			}else {
				selectBook();
			}
		}
		
	}
	
	
//	private String title;
//	private String author;
//	private int year;
//	private int price;
//	private String publisher;
	
	public void insertBook() {
		BookDTO bookDTO = new BookDTO();
		System.out.println("bookno ->");
		bookDTO.setNo(sc.nextLine());
		System.out.println("title ->");
		bookDTO.setTitle(sc.nextLine());
		System.out.println("author ->");
		bookDTO.setAuthor(sc.nextLine());
		System.out.println("year ->");
		bookDTO.setYear(sc.nextInt());
		System.out.println("price ->");
		bookDTO.setPrice(sc.nextInt());
		System.out.println("publisher ->");
		bookDTO.setPublisher(sc.nextLine());
		sc.nextLine();
		
		BookDAO dao = new BookDAO();
		int result = dao.insertBook(bookDTO);
		if (result > 0) {
			System.out.println("정보 등록 성공");
		} else {
			System.out.println("정보 등록 실패");
		}
	}
	
	public void selectBook() {
		BookDAO dao = new BookDAO();
		dao.selectBook(); // 모든 회원 출력
	}
	
	public void Output() {
		System.out.print("1.도서등록, 2.도서목록");
	}

	public static void main(String[] args) {
		new BookTest().start();
	}
}
