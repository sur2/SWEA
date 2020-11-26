import java.util.Scanner;

// 1989. 초심자의 회문 검사 D2
public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int t = 1; t <= T; t++) {
			int answer = 0;
			
			String input = sc.nextLine();
			int len = input.length();
			
			// level
			// len = 5
			// 0 1 2 3 4
			// 0 == 4
			// 1 == 3
			// 2 == 2
			for (int i = 0; i <= len / 2; i++) {
				if (input.charAt(i) != input.charAt(len - 1 - i)) {
					break;
				}
				else {
					answer = 1;
				}
			}
			System.out.println("#" + t + " " + answer);
		}
	}

}
