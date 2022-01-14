package javaProject1;

public class ProductTest {

	public static void main(String[] args) {
		Product prd1 = new Product("001", "노트북", 1200000, 2021, "삼성");
		Product prd2 = new Product("002", "모니터", 300000, 2021, "LG");
		Product prd3 = new Product("003", "마우스", 30000, 2020, "로지텍");

		
		System.out.println("상품번호\t상품명\t가격\t연도\t제조사");
		System.out.println("-------------------------------------");
		
		System.out.println(prd1.toString());
		System.out.println(prd2.toString());
		System.out.println(prd3.toString());

	}

}

class Product {
	
	String prdNo;
	String prdName;
	int prdPrice;
	int prdYear;
	String prdMaker;
	
	public Product(String prdNo, String prdName, int prdPrice, int prdYear, String prdMaker) {
		this.prdNo = prdNo;
		this.prdPrice = prdPrice;
		this.prdYear = prdYear;
		this.prdName = prdName;
		this.prdMaker = prdMaker;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return prdNo + "\t" + prdName + "\t" + prdPrice + "\t" + prdYear + "\t" + prdMaker;
	}

}

