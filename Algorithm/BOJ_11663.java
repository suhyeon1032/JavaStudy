package week20;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11663 {
	public static void main(String[] args) throws IOException {
		// 선분 위의 점
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
 
        st = new StringTokenizer(br.readLine());
        int[] point = new int[N];
        for(int i=0;i<N;i++) point[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(point);
 
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int sum = M;
 
            int left = 0; int right = N-1;
 
            while(left<=right){
                int mid = (left+right)/2;
 
                if(point[mid]>=a) right = mid-1;
                else left = mid+1;
            }
            sum -= left;
            right = N-1;
            while(left<=right){
                int mid = (left+right)/2;
 
                if(point[mid]>b) right = mid-1;
                else left = mid+1;
            }
            sum -= (M-left);
            bw.write(sum+"\n");
        }
        br.close();
        bw.close();
	}

}
