package ssafy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		int arr[][] = new int[N][N];
		
		for(int i=0; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; st.hasMoreTokens(); j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				System.out.print(arr[i][j]);
			}
		}
		

	}

}
