import java.util.Scanner;

// 2007. 패턴 마디의 길이 D2
public class Solution {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		sc.nextLine();
		
		for (int t = 1; t <= T; t++) {
			int answer = 0;
			
			String input = sc.nextLine();
			
			String word = "";

			for (int i = 1; i <= 10; i++) {
				// 문자 길이가 1, 2, 3 ... 하나씩 늘려서 문자열 비교
				// koreakoreakorea 의 경우 
				// k
				// ko
				// kor
				// ...
				// korea
				// ...
				word = input.substring(0, i);
				
				int len = input.length();
				boolean flag = true;
				for (int j = i; j + i <= len; j += i) {
					//System.out.println(input.substring(j, j + i) + ", " + word);
					// 잘라낸 문자열의 길이 만큼 전체 문자열에서 잘라서 비교
					// k == k, k != o
					// ko != re
					// ...
					// korea == korea
					// ...
					if (!input.substring(j, j + i).equals(word)) {
						// i, j
						// 5, 10
						// 10, 15
						// 15, 20
						// 20, 25
						// 25, 30
						flag = false;
						break;
					}
					answer = i;
				}
				// 결과를 구했으니 반복문 탈출
				// 탈출하지 않으면 반복되는 더 긴 문자열의 길이가 반환됨
				// abcabcabcabc -> abc
				// abcabcabcabc -> abcabc 
				// 둘 다 반복되는 문자열이기 때문
				if (answer > 0) {
					break;
				}
				
			}
			
			System.out.println("#" + t + " " + answer);
		}
	}

}
