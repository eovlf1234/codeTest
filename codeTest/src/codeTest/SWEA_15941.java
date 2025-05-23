package codeTest;

import java.util.Scanner;

public class SWEA_15941 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int i = 1; i <= TC; i++) {
			int num = sc.nextInt();
			System.out.println("#" + i + " " + (num * num));
		}
		
	}
}

// 너무 쉽당...
// 다른사람의 풀이를 보고
// num * num 대신 pow를 통해 제곱으로 풀 수 있따는 사실도 알게 되었땅..