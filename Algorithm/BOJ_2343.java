package week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2343 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		int min = 0;
		int max = 0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(" ");
			max += arr[i];
		}
		br.close();
		
		while(min <= max) {
			int mid = (min + max) / 2;
			int sum = 0;
			for(int i=0; i<N; i++) {
				if(sum)
			}
		}
	}

}
