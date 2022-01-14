package javaProject1;

public class ProductTest {

	public static void main(String[] args) {
		Product prd1 = new Product("001", "��Ʈ��", 1200000, 2021, "�Ｚ");
		Product prd2 = new Product("002", "�����", 300000, 2021, "LG");
		Product prd3 = new Product("003", "���콺", 30000, 2020, "������");

		
		System.out.println("��ǰ��ȣ\t��ǰ��\t����\t����\t������");
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

