package codeTest;

import java.util.Scanner;

public class ct_2025_05_01_sw_2805 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i = 1; i <= T; i++) {
			int num = sc.nextInt();
			System.out.println("#" + i + " " + num / 3);
		}
	}

}

// SWEA 문제를 처음 풀어봐서 문제 제출하는데 어려움이 있었다.
// 3명 이상의 수로 구성된 최대 조의 수를 계산하는 문제라서 3명씩 묶고 남은 사람은
// 남은 조에 넣으면 되니깐 3으로 나눈 몫이 최대라고 생각해서 입력된 수 나누기 3으로 출력
// 3레벨 문제가 맞낭?...