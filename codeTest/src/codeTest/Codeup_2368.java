package codeTest;

public class Codeup_2368 {
	public static void main(String[] args) {
		int max = 0;
		
		int kong = 21064 / 40;
		int go = 22054 / 50;
		int dor = 23063 / 30;
		
		if(kong < go && kong < dor) {
			max = kong;
		} else if(go < kong && go < dor) {
			max = go;
		} else if(dor < go && dor < kong) {
			max = dor;
		}
		
		System.out.println(max);
	}
}

// 처음엔 if문에서 하나의 결과만 검사해서 if문 안에 if문을 써서
// 결과를 max에 저장하려고 했는데 생각보다 헷갈리고,
// 코드를 이해하기 어려울 것 같아서 else if문으로 작성
// 