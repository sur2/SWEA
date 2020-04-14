import java.util.Scanner;

// 8382. 방향 전환 D4 
public class Solution {
	
	private static int T;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			int result = 0;
			
			// (x1, y1), (x2, y2)의 차이 
			int x = Math.abs(x1 - x2);
			int y = Math.abs(y1 - y2);
			// 각 좌표 차이의 최대, 최소
			int max = Math.max(x, y);
			int min = Math.min(x, y);
			// 최대 최소의 차이
			int atom = max - min;
			// 규칙
			// 각 좌표의 차이가 같을 땐 그 수의 두 배 만큼 이동 해야한다.
			if (x == y) {
				result = max * 2;
			}
			// 다르다면 각 좌표의 차이가 같을 때(min) 그 수의 두배만큼 이동하고
			// 남은 수가 짝수 이면 2n, 홀수이면 2n-1 한다.
			else {
				result = atom % 2 == 0 ? min * 2 + atom * 2 : min * 2 + atom + atom - 1;
			}

			System.out.println("#" + t + " " + result);
		}
	}

}
