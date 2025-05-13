package codeTest;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1222 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 1; i <= 10; i++) {
			int num = sc.nextInt();				// 계산식의 길이
			sc.nextLine();
			String input = sc.nextLine();		// 입력받은 식
			String[] arr = input.split("");		// 식을 하나씩 배열에 저장
			
			for(int j = 0; j < arr.length - 1; j++) {
				if(arr[j].equals("+")) {
					String temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					j++;
				}
			}
			
			Stack<Integer> stack = new Stack<Integer>();
			
			for(int j = 0; j < arr.length; j++) {
				if(!arr[j].equals("+")) {
					stack.push(Integer.parseInt(arr[j]));
				} else {
					int a = stack.pop();
					int b = stack.pop();
					int result = a + b;
					stack.push(result);
				}
			}
			System.out.println("#" + i + " " + stack.pop());
			
		}
	}
}

// 1주차에 더 어려운걸 풀어서 2주차는 쉽게 풀 수 있었당...
// 문제에 후위계산식을 설명해줘서 후위계산식으로 바꾸고 스택을 활용해서 풀었는데
// 후위계산식을 사용하지 않고 split할 때 +를 통해 끊고
// 모든 배열을 더하면 더 쉽게 구할 수 있을 것 같긴 하다...