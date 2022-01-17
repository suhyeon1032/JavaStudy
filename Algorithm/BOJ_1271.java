package week1;

import java.util.Scanner;
import java.math.BigInteger;

public class BOJ_1271 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger n = sc.nextBigInteger(); // 입력조건의 10의 1000제곱을 달성하기 위해 BigInteger 사용
		BigInteger m = sc.nextBigInteger(); // int가 아닌 문자열 형대로 이루어져 있어 숫자의 범위가 무한이다.
		sc.close();
		
		System.out.println(n.divide(m)); // 나누기 값
		System.out.println(n.remainder(m)); // 나머지 값
		
//		BigInteger 연산
//		더하기 : add()
//		빼   기 : subtract()
//		곱하기 : multiply()
//		나누기 : divide()
//		나머지 : remainder()
	}
}
