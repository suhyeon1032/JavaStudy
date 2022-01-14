package javaProject2;

public class BookTest {

	public static void main(String[] args) {
		System.out.println("도서번호\t도서명\t\t저자\t가격\t발행일\t출판사");
		System.out.println("-------------------------------------------------------");
		
		Book bk1 = new Book("B001","자바 프로그래밍","홍길동",25000,2021,"멀티출판사");
		Book bk2 = new Book("B002","자바스크립트","이몽룡",30000,2020,"서울출판사");
		Book bk3 = new Book("B003","HTML/CSS","성춘향",18000,2021,"강남출판사");
		System.out.println(bk1.toString());
		System.out.println(bk2.toString());
		System.out.println(bk3.toString());
		
		System.out.println();
		System.out.println("잡지번호\t잡지명\t발행인\t가격\t발행연도\t출판사\t발행월");
		System.out.println("-------------------------------------------------------");
		
		Magazine ma1 = new Magazine("M001","자바 월드","홍길동",25000,2021,"멀티출판사",5);
		Magazine ma2 = new Magazine("M002","웹 월드","이몽룡",30000,2020,"서울출판사",7);
		Magazine ma3 = new Magazine("M003","게임 월드","성춘향",18000,2021,"강남출판사",9);
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

