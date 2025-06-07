package codeTest;

import java.util.ArrayList;
import java.util.List;

public class Codeup_2380 {

	public static void main(String[] args) {
		List<Integer> cake = new ArrayList<Integer>();
		
		for(int i = 1; i <= 10; i++) {		// 케이크 1 2 3 4 5 6 7 8 9 10
			cake.add(i);
		}
		
		int[] num = {7, 4, 1, 10, 2, 3, 5, 6, 8, 9}; // 케이크번호 7 4 1 10 2 3 5 6 8 9
		
		int[] count = new int[10];
		
		for(int i = 0; i < num.length; i++) {
			int number = num[i];				// 케이크번호
			int index = cake.indexOf(number);	// 케이크번호의 index를 확인
			int slice = 0;						// 자른 횟수
			
//			// 맨 앞 or 맨 뒤 인경우 따로 체크
//			if((index == 0 && cake.get(index+1) != 0) || (index == 9 && cake.get(index-1) != 0)) {
//				slice = 1;
//			} else if(index != 0 && index != 9) {
//				if(cake.get(index-1) != 0 && cake.get(index+1) != 0) {	// 중간인 경우 왼 오 케이크가 있으면
//					slice = 2;
//				} else if (cake.get(index-1) == 0) {		// 중간인 경우 왼 없는 경우
//					if(cake.get(index+1) != 0) {			// 왼 없고 오 있는 경우
//						slice = 1;
//					} else {								// 왼 없고 오 없는 경우
//						slice = 2;
//					}
//				} else if(cake.get(index-1) != 0) {			// 중간인 경우 왼 있는 경우
//					if(cake.get(index+1) != 0) {			// 왼 있고 오 있는 경우
//						slice = 2;
//					} else {								// 왼 있고 오 없는 경우
//						slice = 1;
//					}
//				}
//			}
			
			// 위 코드는 중복되는 경우도 있고 오류도 있어서 gpt 통해 새로 정리
			////////////
			if(index == 0) {							// 첫번째 인덱스이면
				if(cake.get(index+1) != 0) {			// 다음께 있는지 확인
					slice = 1;							// 있으면 1번 자름
				}
			}
			else if(index == 9 ) {						// 마지막 인덱스이면
				if(cake.get(index-1) != 0) {			// 이전께 있는지 확인
					slice = 1;							// 있으면 1번 자름
				}
			}
			else {											// 중간 인덱스이면
				boolean left = cake.get(index-1) != 0;		// 왼쪽인덱스 저장
				boolean right = cake.get(index+1) != 0;		// 오른쪽인덱스 저장
				
				if(left && right) {							// 둘 다 있으면 2
					slice = 2;
				} else if((!left && right) || (left && !right)) {	// 하나만 있으면 1
					slice = 1;
				}
			}
			/////////////
			
			count[i] = slice;		// 자른횟수 저장
			cake.set(index, 0);		// 케이크를 가져가면 0으로 변경
		}
		
		int once = 0;
		int twice = 0;
		for(int i = 0; i < count.length; i++) {	// 자른 횟수 확인
			if(count[i] == 1) {				// 1이면 once +1
				once++;
			} else if (count[i] == 2) {		// 2면 twice +1
				twice++;
			}
		}
		
		System.out.println(once + " " + twice);		// 자른횟수 출력
	}

}

// int index = cake.indexOf(number);
// 이 부분에서 number를 넣어야 하는데 num을 넣어놔서 오류가 발생
// 여기가 문제인줄 모르고 아래에서 코드를 수정하다 안되서 chatgpt에게 물어봄
// if문을 수정하게 되었고, 그래도 해결이 안되서 다시 물어보니
// number가 문제인걸 알게됨.
// 수정하고 내 코드를 실행해보니 다른 답이 나옴 >> 중복된 코드가 있어서 오류가 있었던것 같음
// if문을 chatgpt를 통해 간단하게 고치고 출력해보니 답이 정상적으로 나옴
// if문을 쉽게 만든다고 저렇게 했는데 오히려 더 어렵게 if문을 사용하게 된 것 같다...
// 다음에 이런 경우가 생긴다면 위 코드처럼 경우를 확실하게 나누는게 
// 이해하기도 좋고 코드 오류도 덜 발생할 것 같다