import java.util.Scanner;

// 2007. ���� ������ ���� D2
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
				// ���� ���̰� 1, 2, 3 ... �ϳ��� �÷��� ���ڿ� ��
				// koreakoreakorea �� ��� 
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
					// �߶� ���ڿ��� ���� ��ŭ ��ü ���ڿ����� �߶� ��
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
				// ����� �������� �ݺ��� Ż��
				// Ż������ ������ �ݺ��Ǵ� �� �� ���ڿ��� ���̰� ��ȯ��
				// abcabcabcabc -> abc
				// abcabcabcabc -> abcabc 
				// �� �� �ݺ��Ǵ� ���ڿ��̱� ����
				if (answer > 0) {
					break;
				}
				
			}
			
			System.out.println("#" + t + " " + answer);
		}
	}

}
