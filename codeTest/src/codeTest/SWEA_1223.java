package codeTest;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_1223 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 1; i <= 10; i++) {				// 10회 반복
			int input_num = sc.nextInt();			// 입력된 숫자 저장
			sc.nextLine();
			String[] op = new String[input_num];	// 입력된 숫자만큼의 배열생성
			op = sc.nextLine().split("");			// 배열에 하나씩 문자 저장
			
			for(int j = 0; j < op.length; j++) {	// *가 나오면 숫자와 *체인지 >> 후위로 변환
				if(op[j].equals("*")) {
					op[j] = op[j+1];
					op[j+1] = "*";
					j++;
				}
			}

			for(int j = 0; j < op.length; j++) {	
				if(op[j].equals("+")) {				// +가 나오면 한칸씩 앞으로 땡기고 마지막에 + 추가
					while(j <= op.length-2) {		// >> 이렇게 한이유
						op[j] = op[j+1];			// 수식을 보니 +가 나오면 다음 + 위치로 이동하게 되어 있음
						j++;						// 따라서 모든 수를 앞으로 밀고 마지막에 +를 추가
					}
					op[op.length-1] = "+";
				}
			}
			
			
			Stack<Integer> stack = new Stack<Integer>();		// 후위식을 계산하기 위해 스택 생성
			for(int j = 0; j < op.length; j++) {
				if(!op[j].equals("+") && !op[j].equals("*")) {	// if 배열이 +, * 아니면(숫자면) 스택에 푸시 
					stack.push(Integer.parseInt(op[j]));
				} else {
					int num1 = stack.pop();						// else +, *이면 스택에 담긴 수 두개를 꺼냄 
					int num2 = stack.pop();
					
					if(op[j].equals("+")) {						// if +이면 두개를 더해서 스택에 푸시
						stack.push(num1 + num2);
					} else if(op[j].equals("*")) {				// else if *이면 두개를 곱해서 스택에 푸시
						stack.push(num1 * num2);
					}
					
					if(j == op.length-1) {									// 마지막 배열이면 꺼내서 출력
						System.out.println("#" + i + " " + stack.pop());
					}
				}
			}
		}
	}
}


// 처음에 후위식으로 바꿔서 정렬한 후 계산하려고 했는데
// 그러면 그냥 *가 나왔을때 앞, 뒤 숫자를 곱하고 저장하면 될 것 같아서 수정함
// 배열에 저장하고 계산하려고 하니 숫자를 사용하고 배열에서 빼내야하며
// 빈배열이 생기기에 배열에서 계산하는것을 포기하고
// 후위식으로 전환한 후 스택을 활용해서 계산하기로 수정함
// 후위식으로 만드는 과정에서 *를 뒤로 보내는 것까진 해결했는데
// +를 뒤로 보내는 과정에서 많은 시간이 사용됨
// +를 뒤로 보내는 식을 보면서 공식을 생각해보니
// +는 다음 +앞으로 온다는 것을 알게되었고
// 처음+는 제거하고 마지막에 +가 붙으면 후위식으로 바뀐다고 생각해서
// 그렇게 풀어보니 답이 나옴!!
// 스택까지는 쉽게 생각이 났는데 후위식으로 변환화는 과정이 어려웠다...
// >> 더 쉽게 하는 방법이 있을것 같음! + for문을 너무 많이 사용한 것 같음!