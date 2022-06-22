package week20;

import java.util.Scanner;

public class BOJ_25178 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		String str1 = sc.next();
		String str2 = sc.next();

		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();

		for (int i = 0; i < N; i++) {
			if (arr1[i] != arr2[i]) {
				if (arr1[i] == 'a' || arr1[i] == 'e' || arr1[i] == 'i' || arr1[i] == 'o' || arr1[i] == 'u') {
					if (arr2[i] == 'a' || arr2[i] == 'e' || arr2[i] == 'i' || arr2[i] == 'o' || arr2[i] == 'u') {
						System.out.println("YES");
						break;
					}
					
				} else {
					System.out.println("NO");
					break;
				}
			} else {
				System.out.println("YES");
				break;
			}
		}
	}
}
