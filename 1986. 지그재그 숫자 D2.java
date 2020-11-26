import java.util.Scanner;

// 1986. 지그재그 숫자 D2
public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int t = 1; t <= T; t++) {
			int answer = 0;
			
			int N = sc.nextInt();
			
			answer = N / 2;
			
			if (N % 2 == 0) {
				answer *= -1;
			}
			else {
				answer += 1;
			}
			
			System.out.println("#" + t + " " + answer);
		}
		
	}

}
