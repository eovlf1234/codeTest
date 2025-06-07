package codeTest;

import java.util.Scanner;

public class SWEA_10505 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int i = 1; i <= T; i++) {				// 전체 테스트케이스
			int t_case = sc.nextInt();
			sc.nextLine();
			String income = sc.nextLine();				// n번째 테스트 케이스
			String[] number = new String[t_case];		// 각각 저장할 배열
			
			number = income.split(" ");
			int sum = 0;
			
			for(int j = 0; j < number.length; j++) {
				sum += Integer.parseInt(number[j]);			// 배열의 값을 모두 더함
			}
			int avg = sum / number.length;					// 평균
			int count = 0;
			for(int j = 0; j < number.length; j++) {
				if(Integer.parseInt(number[j]) <= avg) {	// 평균보다 낮은지 확인
					count++;								// 낮으면 더함
				}
			}
			
			System.out.println("#" + i + " " + count);		// 테스트케이스별 출력
		}
		
	}

}

// 별다른 어려움 없음