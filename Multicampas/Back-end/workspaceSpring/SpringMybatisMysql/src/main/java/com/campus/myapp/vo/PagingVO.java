package com.campus.myapp.vo;

public class PagingVO {
	//1. ����¡
	//    1) �� �������� ����� ���ڵ� ��
	private int onePageRecord = 5;
	//    2) ���� ������
	private int pageNum = 1;
	//    3) �� ���ڵ� �� : DB���� �޾ƿ;� ��
	private int totalRecord;
	//    4) �� ������ ��
	private int totalPage;
	private int offsetIndex;
	private int onePageCount = 5;
	private int startPage = 1;

	//2. �˻�
	private String searchKey;
	private String searchWord;
	
	
	public int getOnePageRecord() {
		return onePageRecord;
	}
	public void setOnePageRecord(int onePageRecord) {
		this.onePageRecord = onePageRecord;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
		//offset��ġ ���
		offsetIndex =(pageNum-1)*onePageRecord;
		//������ ��ȣ�� ���۰�
		startPage = (pageNum-1)/onePageCount*onePageCount+1;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		
		//�� ��������
		if(totalRecord%onePageRecord==0) {//�� �Խñ� ����, �� �������� �Խ��� �� ���� ���� �������� ���
			totalPage = totalRecord/onePageRecord;
		}else {//������������ �ʾ�, ������ �Խñ��� �ִ� ���
			totalPage = totalRecord/onePageRecord +1;
		}
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getOffsetIndex() {
		return offsetIndex;
	}
	public void setOffsetIndex(int offsetIndex) {
		this.offsetIndex = offsetIndex;
	}
	public int getOnePageCount() {
		return onePageCount;
	}
	public void setOnePageCount(int onePageCount) {
		this.onePageCount = onePageCount;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	
}
