package array;

import java.io.*;
import java.util.*;

public class BOJ_20186 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		
		int N = Integer.parseInt(s);
		int M = Integer.parseInt(st.nextToken());
		
		String []arr = new String[N];
		
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toString();
        }
	}

}
