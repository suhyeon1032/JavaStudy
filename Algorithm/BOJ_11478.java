package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


public class BOJ_11478 {
	static HashSet<String> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		
		set = new HashSet<String>();
		
		String name = "";
		
		for(int i=0; i<S.length(); i++) {
			name = "";
			for(int j=i; j<S.length(); j++) {
				name += S.substring(j,j+1);
				set.add(name);
			}
		}
		System.out.println(set.size());
	}

}
