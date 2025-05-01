package codeTest;

import java.util.Scanner;

public class SWEA_12368 {
	
//	하루는 24시간이다. 24시간제 시계에서는 하루가 자정에서 시작해서 다음 날 자정에서 끝나며, 자정에서부터 지금까지 흐른 시간을 기준으로 시각을 표기한다.
//	예를 들어, 지금이 오후 8시라면 “20시”와 같은 꼴로 표현할 수 있다. 자정을 표기하는 유일한 방법은 “0시”임에 유의하라.
//	지금은 자정에서부터 정확히 A시간이 지났다. 앞으로 정확히 B시간이 더 지난다면, 24시간제 시계에서 그 때는 몇 시일까?
	
//	[입력]
//	  첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//	  각 테스트 케이스의 첫 번째 줄에는 두 개의 정수 A, B (0 ≤ A, B ≤ 23)이 공백 하나를 사이로 두고 순서대로 주어진다.
//	[출력]
//	  각 테스트 케이스마다, 현재 A시인 상황에서 앞으로 B시간이 지나면 몇 시가 되는지를 출력한다.
	
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