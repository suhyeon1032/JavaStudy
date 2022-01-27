package al02_sort;

import java.util.Arrays;

public class QuickSort {

   public static void swap(int a[], int idx1, int idx2) {
      int temp = a[idx1];
      a[idx1] = a[idx2];
      a[idx2] = temp;
   }
   
   //   반환
   public static void myQuick(int a[], int left, int right) {
      int pl = left;                  //   왼쪽부터 검색할 index 위치
      int pr = right;                  //   오른쪽부터 검색할 index 위치
      int pivot = a[(left+right)/2];      //   피벗 위치 값을 구한다.
      
      do {
         
         //   피벗기준 왼쪽에서 오른쪽으로 피벗의 값보다 큰 데ㅣ터가 있는 index 찾기
         while(a[pl] < pivot) {pl++;}   
         //   피벗기준 오른쪽에서 왼쪽으로 이동하며 피벗의 값보다 작은데이터가 있는 index 찾기
         while(a[pr] > pivot) {pr--;}
         if(pl <= pr) {      //pl의 위치 값과, pr의 위치 값을 교환한다.
            swap(a, pl++, pr--);
         }
      }while(pl<=pr);
      
      System.out.println(Arrays.toString(a));
      System.out.println("pl -> "+pl+", pr -> "+pr);
      
      //   정렬 후  왼쪽을 재정렬할 재귀호출
      if(left < pr) {
         myQuick(a,left,pr);
      }
      
      //   정렬 후 오른쪽 재정렬 할 재귀호출
      if(pl < right) {
         myQuick(a,pl,right);
      }
      
   }
   
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      int arr[]= {175,170,160,168,165,170,155,150};
      System.out.println(Arrays.toString(arr));
      myQuick(arr,0,arr.length-1);      
      
   }

}