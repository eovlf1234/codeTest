package codeTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Alpha {
	
	//	주어진 문자열 "hi, my name is dongwon. nice to meet you" 에서
	//	각 문자의 등장 횟수와 가장 많이 등장한 문자 모두를 출력하는 프로그램을 작성하시오.
	//	단, 가장 많이 등장한 문자를 출력할 때, 공백은 제외한다.
	//	출력예시) e : 6, d: 6
	
	public static void main(String[] args) {
		String str = "hi, my name is dongwon. nice to meet you";
		str = str.replace(" ", "");
		String[] arr = str.split("");
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i = 0; i < arr.length; i++) {
			if(map.get(arr[i]) == null) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], map.get(arr[i]) + 1);
			}
		}

		int max = 0;
		Stack<String> out = new Stack<String>(); 
		
		for(String key : map.keySet()) {
			System.out.print(key + " : " + map.get(key) + " ");
			if(max < map.get(key)) {
				max = map.get(key);
				out.clear();
				out.push(key);
			} else if (max == map.get(key)) {
				out.push(key);
			}
		}
		
		String value = "";
		String out_str = "";
		
		while(!out.isEmpty()) {
			value = out.pop();
			out_str += value + " : " + map.get(value) + " ";
		}
		
		System.out.println();
		System.out.println(out_str);
		
	}
}
