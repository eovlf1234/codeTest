package codeTest;

import java.util.Scanner;

public class ct_2025_05_01_sw_12368 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int i = 1; i <= T; i++) {
			String input = sc.nextLine();
			String[] num = input.split(" ");
			int result = Integer.parseInt(num[0]) + Integer.parseInt(num[1]);
			if(result > 24) {
				result -= 24;
			} else if (result == 24) {
				result = 0;
			}
			System.out.println("#" + i + " " + result);
		}
		
	}
}

// 처음 시간에서 두번째 시간을 더해서 24시간제로 표시 문제!
// 두 수를 더해서 24보다 클경우 24를 빼고 같으면 0으로 표시!
// 코드를 제대로 작성했다고 생각했지만 nextLine()을 사용하는 부분에서
// nextLine은 개행 문자 이전까지의 값들을 가져오는데 nextInt에선 개행문자를 소비하지 않아서
// nextLine을 사용했을때 빈문자열로 받아오는 오류가 발생했음!! 예전에도 이런적이 있었는데
// 생각을 하지 못했다... 다음부터는 이런 오류를 범하지 않도록 조심해야겠다!!