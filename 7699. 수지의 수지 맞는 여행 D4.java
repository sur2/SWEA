import java.util.Scanner;

// 7699. 수지의 수지 맞는 여행 D4
public class Solution {

	private static Scanner sc = new Scanner(System.in);
	private static int T = 0;
	private static int R = 0;
	private static int C = 0;
	private static int result = 0;
	private static char[][] map = null;
	private static boolean[][] visit = null;
	private static boolean[] alpha = null;

	public static void main(String[] args) {
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			R = sc.nextInt();
			C = sc.nextInt();

			result = 0;

			R += 1;
			C += 1;

			map = new char[R][C];

			for (int r = 1; r < R; r++) {
				String temp = sc.next();
				for (int c = 1; c < C; c++) {
					map[r][c] = temp.charAt(c - 1);
				}
			}
			
			result = 0;
			visit = new boolean[R][C];
			alpha = new boolean[91];
			visit[1][1] = true;
			alpha[map[1][1]] = true;
			recursive(1, 1, 0);
			result += 1;
			System.out.println("#"+t+" "+result);
//			visitPrint();
		}
	}

	private static void visitPrint() {
		for (int i = 0; i < visit.length; i++) {
			for (int j = 0; j < visit[i].length; j++) {
				System.out.print(visit[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void recursive(int r, int c, int count) {
		if (r + 1 < R) {
			if (!visit[r + 1][c] && !alpha[map[r + 1][c]]) {
				visit[r + 1][c] = true;
				alpha[map[r + 1][c]] = true;
				count++;
//				System.out.println(map[r + 1][c] + " : " + (r + 1) + ", " + c);
				recursive(r + 1, c, count);
				visit[r + 1][c] = false;
				alpha[map[r + 1][c]] = false;
				count--;
			}
		}
		if (c + 1 < C) {
			if (!visit[r][c + 1] && !alpha[map[r][c + 1]]) {
				visit[r][c + 1] = true;
				alpha[map[r][c + 1]] = true;
				count++;
//				System.out.println(map[r][c + 1] + " : " + r + ", " + (c + 1));
				recursive(r, c + 1, count);
				visit[r][c + 1] = false;
				alpha[map[r][c + 1]] = false;
				count--;
			}
		}
		if (r - 1 > 0) {
			if (!visit[r - 1][c] && !alpha[map[r - 1][c]]) {
				visit[r - 1][c] = true;
				alpha[map[r - 1][c]] = true;
				count++;
//				System.out.println(map[r - 1][c] + " : " + (r - 1) + ", " + c);
				recursive(r - 1, c, count);
				visit[r - 1][c] = false;
				alpha[map[r - 1][c]] = false;
				count--;
			}
		}
		if (c - 1 > 0) {
			if (!visit[r][c - 1] && !alpha[map[r][c - 1]]) {
				visit[r][c - 1] = true;
				alpha[map[r][c - 1]] = true;
				count++;
//				System.out.println(map[r][c - 1] + " : " + r + ", " + (c - 1));
				recursive(r, c - 1, count);
				visit[r][c - 1] = false;
				alpha[map[r][c - 1]] = false;
				count--;
			}
		}
		if(result < count) {
			result = count;
		}
	}

}
