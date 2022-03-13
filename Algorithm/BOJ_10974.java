package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10974 {
	static int N;
	static int[] arr;
	static int[] output;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		output = new int[N];
		visited = new boolean[N];
		
		for (int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		
		permutation(0);
		
		
	}
	private static void permutation(int depth) {
		
		if (depth == N) {
			for(int i=0; i<N; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i< arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				permutation(depth+1);
				visited[i] = false;
			}
		}
	}
}
