import java.util.Arrays;
import java.util.Scanner;

// 7810. 승현이의 질문 D4
public class Solution {
	
	static int N = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int t = 1; t <= tc; t++) {
			N = sc.nextInt();
			int sequence[] = new int[N];
			for (int i = 0; i < N; i++) {
				sequence[i] = sc.nextInt();
			}
			Arrays.sort(sequence);
			int h = 0;
			for (int i = 0; i < N; i++) {
				if (sequence[N-i-1] > h) {
					h++;
				}
				else {
					break;
				}
			}
			System.out.println("#"+t+" "+h);
		}
	}
}
