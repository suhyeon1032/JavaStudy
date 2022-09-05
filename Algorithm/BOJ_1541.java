package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1541 {

	public static void main(String[] args) throws IOException {
		// 잃어버린 괄호
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = Integer.MAX_VALUE;
		String[] str = br.readLine().split("-");
		
		for(int i = 0; i<str.length; i++) {
			int tmp = 0;
			
			String[] add = str[i].split("\\+");
			
			for(int j=0; j<add.length; j++) {
				tmp += Integer.parseInt(add[j]);
			}
			
			if(sum == Integer.MAX_VALUE) {
				sum = tmp;
			} else {
				sum -= tmp;
			}
		}
		System.out.println(sum);
	}

}
