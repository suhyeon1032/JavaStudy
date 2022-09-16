package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1543 {

	public static void main(String[] args) throws IOException {
		// 문서 검색
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String s = br.readLine();
		
		int cnt = 0;
		
		for(int i=0; i<str.length()-s.length()+1; i++) {
			if(str.substring(i, i+s.length()).equals(s)) {
				cnt++;
				i += s.length()-1;
			}
		}
		System.out.println(cnt);
		
	}

}
