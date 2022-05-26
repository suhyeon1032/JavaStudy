package week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_25186 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		long max = 0;
		int n = Integer.parseInt(br.readLine());
		long arr[] = new long[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = (arr[i] > max) ? arr[i] : max;
			sum += arr[i];
		}
		if(n==1) {
			System.out.println("Happy");
		}
		if(sum/2 >= max) {
			System.out.println("Happy");
		}else {
			System.out.println("Unhappy");
		}
			
	}

}
