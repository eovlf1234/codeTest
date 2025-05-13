package codeTest;

import java.util.Scanner;

public class Codeup_2369 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String inputs = sc.nextLine();
		
		String[] input = inputs.split(" ");
		Integer[] div_num = {40, 50, 30};
		
		int min = Integer.parseInt(input[0]) / div_num[0];
		
		for(int i = 1; i < input.length; i++) {
			int num = Integer.parseInt(input[i]) / div_num[i];
			if(min > num) {
				min = num;
			}
		}
		
		System.out.println(min);
		
	}

}

// 딱히 어려웠던 부분은 없었던것 같음
// 1. if문에서 입력받은 숫자를 비교할 때 parseInt를 사용하고
// 아래에서 min에 넣을 때 또 parseInt를 사용하는것과 
// 2. num을 통해 for 안에서 parseInt를 사용하고 변수에 저장한 후
// 그 num을 재사용 하는 것 중 어떤게 효율이 좋을지를 고민함.
// chargpt를 통해 확인한 결과 2번을 사용하는 것이 효율이 좋은 것 같음