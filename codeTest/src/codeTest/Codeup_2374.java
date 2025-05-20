package codeTest;

import java.util.HashMap;
import java.util.Map;

public class Codeup_2374 {
	public static void main(String[] args) {
		Map<String, Integer> time = new HashMap<String, Integer>();
		
		time.put("1번", 30);		// 관광지 소요시간
		time.put("2번", 25);
		time.put("3번", 20);
		time.put("4번", 30);
		time.put("5번", 35);
		
		String[][] student = {{"1", "3번,5번,2번"},	// 학생별 관광 순서
							  {"2", "2번,3번,5번"},
							  {"3", "5번,2번,3번"},
							  {"4", "5번,2번,1번"},
							  {"5", "2번,5번,1번"},
							  {"6", "5번,2번,1번"},
							  {"7", "3번,2번,1번"},
							  {"8", "4번,1번,3번"},
							  {"9", "3번,4번,5번"},
							  {"10", "1번,2번,4번"}};
		
		int count = 0;
		
		for(int i = 0; i < student.length; i++) {	// 관광시간 비교
			int minute = calc(student[i][1],time);
			if(minute < 100) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}
	
	public static int calc(String s, Map<String, Integer> time) {		// 학생별 관광순서 계산
		String[] seq = s.split(",");
		int sum = 15;							// 
		for(int i = 0; i < seq.length; i++) {
			sum += time.get(seq[i]);
		}
		
		return sum;
	}
}

// 처음에 메인에서 맵을 만들고 이를 calc메서드에서 사용하려고 하니
// 오류가 떠서 뭐지? 하다가 다른 메서드라 안된다고 생각함
// 처음에 static을 사용하면 되나? 해서 사용해봤는데 오류가 남
// 챗지피티를 통해 배운 결과
// 1. 메서드 내부에서 static을 사용할 수 없고, 밖에서 사용한 후 사용하거나
// 2. calc 메서드를 사용할 때 map도 인자로 넘겨서 사용하는 방법을 알려줌
// 2번 방법이 유지보수를 고려하면 좋다고 해서 사용!