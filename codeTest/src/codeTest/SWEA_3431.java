
public class SWEA_3431 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();           // 입력 테스트 수
        sc.nextLine();
         
        for(int i = 1; i <= T; i++) {
            String input = sc.nextLine();           // 입력된 숫자 저장
            String[] minute = input.split(" ");     // 한줄로 입력된 숫자 배열에 차례대로 저장
            int min_minute = Integer.parseInt(minute[0]);       // 처음 입력된 수 = 최소
            int max_minute = Integer.parseInt(minute[1]);       // 두번째 입력된 수 = 최대
            int use_minute = Integer.parseInt(minute[2]);       // 세번째 입력된 수 = 운동한 시간
            int output = 0;     // 출력될 수    => 운동시간 적절하면 0 그대로 출력
             
            if(use_minute < min_minute) {            // 운동시간이 적으면 더해야할 운동시간 출력
                output = min_minute - use_minute;
            } else if (use_minute > max_minute) {    // 운동시간 많으면 -1 출력
                output = -1;
            }
             
            System.out.println("#" + i + " " + output);
             
        }
    }
}
