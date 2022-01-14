package javaProject2;

public class BookTest {

	public static void main(String[] args) {
		System.out.println("������ȣ\t������\t\t����\t����\t������\t���ǻ�");
		System.out.println("-------------------------------------------------------");
		
		Book bk1 = new Book("B001","�ڹ� ���α׷���","ȫ�浿",25000,2021,"��Ƽ���ǻ�");
		Book bk2 = new Book("B002","�ڹٽ�ũ��Ʈ","�̸���",30000,2020,"�������ǻ�");
		Book bk3 = new Book("B003","HTML/CSS","������",18000,2021,"�������ǻ�");
		System.out.println(bk1.toString());
		System.out.println(bk2.toString());
		System.out.println(bk3.toString());
		
		System.out.println();
		System.out.println("������ȣ\t������\t������\t����\t���࿬��\t���ǻ�\t�����");
		System.out.println("-------------------------------------------------------");
		
		Magazine ma1 = new Magazine("M001","�ڹ� ����","ȫ�浿",25000,2021,"��Ƽ���ǻ�",5);
		Magazine ma2 = new Magazine("M002","�� ����","�̸���",30000,2020,"�������ǻ�",7);
		Magazine ma3 = new Magazine("M003","���� ����","������",18000,2021,"�������ǻ�",9);
		System.out.println(ma1.toString());
		System.out.println(ma2.toString());
		System.out.println(ma3.toString());
	}

}

class Book {

	int bookPrice, bookYear;
	String bookNo, bookTitle, bookAuthor, bookPublisher;


	Book(String bookNo, String bookTitle, String bookAuthor, int bookPrice, int bookYear, String bookPublisher){
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
		this.bookYear = bookYear;
		this.bookPublisher = bookPublisher;
	}
	
	@Override
	public String toString() {
		return bookNo + "\t" + bookTitle + "\t" + bookAuthor + "\t" + bookPrice + "\t" + bookYear  + "\t" + bookPublisher;
	}
	
}

class Magazine extends Book{
	
	int month;
	
    Magazine(String bookNo, String bookTitle, String bookAuthor, int bookPrice, int bookYear, String bookPublisher, int month) {
		super(bookNo, bookTitle, bookAuthor, bookPrice, bookYear, bookPublisher);
		this.month = month;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "\t" + month;
	}

	
    
}

