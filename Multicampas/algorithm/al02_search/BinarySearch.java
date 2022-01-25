package al02_search;

import java.util.Scanner;

public class BinarySearch {
	// 이진 검색(BinarySearch)
	// 데이터가 정렬되어 있어야 한다.
	// 가운데 위치를 구하여 검색한다.
	static int binarySearch(int arr[], int n, int key) { // 이 변수는 이 메소드가 호출되면 생성되는 변수
		int left = 0; // 왼쪽 시작 index
		int rigth = n-1; // 오른쪽 마지막 index
		
		do {
			// 중간 index를 구한다.
			int center = (left+rigth)/2;
			if(key == arr[center]) {
				return center; // 검색할 값이 중간 index에 있을 경우
			} else if(arr[center] < key) {
				left = center+1; // left를 center+1로 바꾼다.
			} else {
				rigth = center-1;
			}
			
		} while(left<=rigth);
		// 검색한 값이 없을 경우
		return -1;
	}
	
	public static void main(String[] args) { // 이 안에 arr, n, key는 main 안에서 생성된 변수
		Scanner s = new Scanner(System.in);
		
		System.out.println("데이터 수 = ");
		int n = s.nextInt();
		
		int arr[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			System.out.println("arr["+i+"]=");
			arr[i] = s.nextInt();
		}
		
		// 검색할 수 입력
		int key = s.nextInt();
		
		// 이진 검색
		int result = binarySearch(arr, n, key);
		if (result>=0) {
			System.out.println(key+"는 arr["+result+"]위치에 있습니다.");
		} else {
			System.out.println(key + "는 존재하지 않는 데이터입니다.");
		}
		
	}
}
