package al02_sort;

import java.util.Arrays;

public class QuickSort {

   public static void swap(int a[], int idx1, int idx2) {
      int temp = a[idx1];
      a[idx1] = a[idx2];
      a[idx2] = temp;
   }
   
   //   ��ȯ
   public static void myQuick(int a[], int left, int right) {
      int pl = left;                  //   ���ʺ��� �˻��� index ��ġ
      int pr = right;                  //   �����ʺ��� �˻��� index ��ġ
      int pivot = a[(left+right)/2];      //   �ǹ� ��ġ ���� ���Ѵ�.
      
      do {
         
         //   �ǹ����� ���ʿ��� ���������� �ǹ��� ������ ū �����Ͱ� �ִ� index ã��
         while(a[pl] < pivot) {pl++;}   
         //   �ǹ����� �����ʿ��� �������� �̵��ϸ� �ǹ��� ������ ���������Ͱ� �ִ� index ã��
         while(a[pr] > pivot) {pr--;}
         if(pl <= pr) {      //pl�� ��ġ ����, pr�� ��ġ ���� ��ȯ�Ѵ�.
            swap(a, pl++, pr--);
         }
      }while(pl<=pr);
      
      System.out.println(Arrays.toString(a));
      System.out.println("pl -> "+pl+", pr -> "+pr);
      
      //   ���� ��  ������ �������� ���ȣ��
      if(left < pr) {
         myQuick(a,left,pr);
      }
      
      //   ���� �� ������ ������ �� ���ȣ��
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