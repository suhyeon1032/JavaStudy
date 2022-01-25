package al02_sort;

import java.util.Arrays;
import java.util.Random;

public class ArrayBubbleSort {

   public static void swap(int a[], int idx1, int idx2) {
      int t = a[idx1];
      a[idx1] = a[idx2];
      a[idx2] = t;
      
   }
   
   //   �������� : ��������      �����͹迭, �����ͼ�(10)
   public static void mySort(int a[], int n) {
      //      9
      for(int j=n-1; j>0; j--) {
         //   8      9
         if(a[j-1] > a[j]) {
         //   ��ȯ
         //         8    9
            swap(a, j-1, j);
         }   
      }
      System.out.println("1������ : "+Arrays.toString(a));
      
   }
   
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub

      Random ran = new Random();
      //   ������ �غ�
      //   1~100������ ������ �����Ͽ� ũ������� ����(��������)
      
      int arr[] = new int[10];
      
      for(int i=0; i<arr.length; i++) {
         arr[i] = ran.nextInt(100)+1;      //   0~99
      }
   
      System.out.println("������ : " + Arrays.toString(arr));
      
      mySort(arr, arr.length);
   
   }

}