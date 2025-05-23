package codeTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_1224 {
	public static void main(String[] args) {
		
		Map<String, Integer> op = new HashMap<String, Integer>();
		op.put("+", 1);		// 연산자 우선순위 지정
		op.put("*", 2);
		op.put("(", 3);
		op.put(")", 0);
		
		Stack<String> st = new Stack<String>();		// 스택 생성
		Scanner sc = new Scanner(System.in);		// 숫자 입력
		
		for(int i = 1; i <= 10; i++) {
			int number = sc.nextInt();
			sc.nextLine();
			
			String input = sc.nextLine();
			String[] str = new String[number];	// 숫자만큼 배열 생성 후 입력받은 문자 배열로 저장
			str = input.split("");
			
			String postfix = "";		// 후위식 변수 선언
			
			// 후위식 변환
			for(int j = 0; j < str.length; j++) {
				String s = str[j];
				Integer oper = op.get(s);		// 연산자 중 있는지 확인(정수면 연산자 아니면 숫자 >> map)
				if(oper != null) {		// 연산자일때
					if(st.empty() || op.get(st.peek()) < oper) {	// 우선순위 높으면 푸쉬
						st.push(s);
					} else if(s.equals(")")) {						// )가 나오면 (가 나올때까지 스택의 연산자 출력
						while(!st.empty() && !st.peek().equals("(")) {
							postfix += st.pop();
						}
						st.pop();		// 연산자를 모두 출력하고 (제거
					} else {			// )가 아닌 연산자가 나올 경우
						while(!st.empty() && op.get(st.peek()) >= oper && !st.peek().equals("(")) { // 우선순위 낮거나 같으면 팝 이 후 푸쉬 
							postfix += st.pop();
						}
						st.push(s);
					}
				} else {	// 숫자일때 후위식에 더함
					postfix += s;
				}
			}
			
			// 후위식 계산			
			String[] arr = postfix.split("");				// 후위식을 배열로 저장
			
			for(int j = 0; j < postfix.length(); j++) {
				String s = arr[j];
				Integer oper = op.get(s);
				if(oper == null) {				// 숫자일 경우 스택에 푸쉬
					st.push(s);
				} else {						// 연산자일 경우 두 수를 저장하고 연산자에 따라 결과 계산 후 다시 푸쉬
					int num1 = Integer.parseInt(st.pop());
					int num2 = Integer.parseInt(st.pop());
					if(s.equals("+")) {
						st.push(String.valueOf(num1 + num2));
					} else if(s.equals("*")) {
						st.push(String.valueOf(num1 * num2));
					}
				}
			}
			
			System.out.println("#" + i + " " + st.pop());		// 계산이 끝난 후 스택에 저장된 결과값 출력
		}
	}

}

// 이전에 비슷한 문제를 풀었을 땐 내 생각대로 후위식으로 변환하여
// 문제를 풀었는데 식이 좀 더 복잡해지니 그런식으로는 풀 수 없을 것 같았다.
// 여러가지 시도를 해봤지만 규칙을 찾을 수 없었고, 이에 따라 구글링을 통해
// 연산자를 스택에 저장하여 후위식으로 변환할 수 있다는 사실을 알 수 있었다.
// 연산자를 스택에 저장하여 우선순위를 활용하여 후위식으로 변환하였는데,
// 괄호를 해결하기 위해 많은 시간이 소모됐다... sysout을 통해 디버깅을 하면서
// 코드를 짜는데도 이해하기 힘들었다..
// 이번 코테를 통해 push, pop, peek등 스택에 대해 좀 더 이해하고 사용법을 배울 수 있었으며,
// 알고리즘적 사고를 키울 수 있었던 것 같다!
// 사전지식이 없어서 그런가 역대급 어려운 문제였는듯...