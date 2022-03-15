package com.campus.myapp;

public class ProductVO {
	private int proNo;
	private String proName;
	private String option; 
	public int price;
	public int cnt;
		
	public ProductVO(int proNo, String proName, int price, int cnt) {
		this.proNo = proNo;
		this.proName = proName;
		this.price = price;
		this.cnt = cnt;
	}
	
	public void setProNo(int proNo) {
		this.proNo = proNo;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
}
