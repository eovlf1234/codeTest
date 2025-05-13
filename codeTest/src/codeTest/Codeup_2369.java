package codeTest;

import java.util.Scanner;

public class Codeup_2369 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String inputs = sc.nextLine();
		
		String[] input = inputs.split(" ");
		int min = 0;
		for(String value : input) {
			Integer.parseInt(value);
		}
		
		int min = Math.min(a/40, Math.min(b/50, c/30));
		
		System.out.println(min);
		
	}

}
