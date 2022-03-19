package week9;

import java.util.HashSet;
import java.util.Iterator;

public class Solution {
	public static HashSet<Integer> set = new HashSet<>(); // Integer형의 HashMap 데이터

	public int solution(String numbers) {
		permutation("", numbers);
		
		int count = 0;
		Iterator<Integer> it = set.iterator(); // set.iterator()로 set 값을 iterator에 담는다.
		while (it.hasNext()) { // set.iterator().hasNext() 들어있으면 true 안들어있으면 false
			int num = it.next(); // Iterator.next() iterator의 값을 하나씩 뽑아낸다.
			if (isPrime(num))
				count++;
		}
		return count;
	}

	// 순열
	public static void permutation(String prefix, String str) {
		if (!prefix.equals("")) { //prefix이 공백이 아니라면
			set.add(Integer.parseInt(prefix)); // Integer로 변환
		}
				
		for (int i = 0; i < str.length(); i++) {
			permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1));
			// str.charAt(i) i번째 문자열 가져오기
			// str.substring(0,1) 0번부터 1만큼 문자 잘라내기
		}
	}

	// 소수찾기
	public static boolean isPrime(int num) {
		if (num <= 1) { // 0,1일 경우 false
			return false;
		}

		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}