package week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1459 {

	public static void main(String[] args) throws IOException {
		// 걷기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Long.parseLong(st.nextToken()); // ~10억
        long Y = Long.parseLong(st.nextToken()); // ~10억
        long W = Long.parseLong(st.nextToken()); // 수평 ~10,000
        long S = Long.parseLong(st.nextToken()); // 대각선 ~10,000

        long cost1, cost2, cost3;
        
        cost1 = (X+Y) * W;
        
        if((X + Y) %2 == 0) cost2 = Math.max(X, Y) * S;
        else cost2 = ((Math.max(X, Y) -1) * S) + W;
        
        cost3 = (Math.min(X, Y) * S) + (Math.abs(X-Y) * W);
        
        long ans = Math.min(Math.min(cost1, cost2), cost3);
        System.out.println(ans);
	}

}
