package codeTest;

public class Codeup_2377 {
	public static void main(String[] args) {
		int[] milk = {25, 15, 10};		// 컨디션에 따른 우유 생산량
		int cheese_milk = 2024 * 10;		// 치즈 2024kg을 만들기 위해 필요한 우유량
		
		int sum = 0;
		for(int i = 0; i < milk.length; i++) {	// 높은 수부터 필요한 최대수를 계산
			int m = milk[i];					
			sum += cheese_milk / m;
			cheese_milk %= m;					// 남은 필요 우유량 저장
		}
		
		System.out.println(sum);				// 최소 마리수
		
	}
}
