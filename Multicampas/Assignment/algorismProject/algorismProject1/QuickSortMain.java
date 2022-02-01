package algorismProject1;

import java.util.Scanner;

public class QuickSortMain {
	
	//배열 내 위치 교환 메서드
	public static void swap(int a[],int idx1, int idx2) {
		int temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}
	
	//퀵정열 알고리즘 메서드
	public static void myQuick(int a[], int left, int right) {
		int pl = left;  //pointLeft
		int pr = right; //pointRight
		int pivot = a[(left+right)/2];
		
		do {
			//pivot기준으로 왼쪽에서 오른쪽으로 피벗의 값보다 큰 값의 인덱스 찾기
			while(a[pl]<pivot) pl++; //pivot값보다 작으면 다음으로 넘어가
			//pivot기준으로 오른쪽에서 왼쪽으로 피벗값보다 작은 값의 인덱스 찾기
			while(a[pr]>pivot) pr--;//pivot값보다 크면 다음으로 넘어가
			
			if(pl<=pr) { //pl위치의 값과 pr위지의 값 교환
				swap(a,pl++,pr--);
			}
		}while(pl <= pr);
				
		//정렬 후 왼쪽을 다시 정렬하는 재귀 호출
		if(left < pr) {
			myQuick(a, left, pr);
		}
		//정렬 후 오른쪽을 다시 정렬하는 재귀 호출
		if(pl < right) {
			myQuick(a, pl, right);
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("학생 수 입력 : ");
		int num = scan.nextInt();
		int scores[] = new int[num];
		
		for(int i = 0; i<num; i++) {
			System.out.print("학생 "+(i+1)+" 점수 입력 : ");
			scores[i] = scan.nextInt();
		}
		myQuick(scores,0,scores.length-1);
		
		System.out.println("성적 순으로 정렬");
		for(int i = num-1; i>=0; i--) {
			System.out.println((num-i)+"등 : "+scores[i]);
		}
		scan.close();
	}
}

 