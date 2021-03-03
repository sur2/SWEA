import java.util.Scanner;

// 11545. 틱택톰 D4
public class Solution {

	public static int T;
	public static char[][] fxf = new char[4][4];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			sc.nextLine();
			// 4x4
			for (int i = 0; i < 4; i++) {
				String input_line = sc.nextLine();
				for (int j = 0; j < 4; j++) {
					fxf[i][j] = input_line.charAt(j);
				}
			}
			
			String output = "";
			if (IsFull()) {
				if (WhoIsWinner() == 'O') {
					output = "O won";
				}
				
				if (WhoIsWinner() == 'X') {
					output = "X won";
				}
				
				if (WhoIsWinner() == 'T') {
					output = "Draw";
				}
			} else {
				if (WhoIsWinner() == 'O') {
					output = "O won";
				}
				
				if (WhoIsWinner() == 'X') {
					output = "X won";
				}
				
				if (WhoIsWinner() == 'T') {
					output = "Game has not completed";
				}
			}
			
			System.out.println("#" + t + " " + output);

		}
	}

	public static void print() {
		// print
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(fxf[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	public static char WhoIsWinner() {

		// 가로 4개
		for (int i = 0; i < 4; i++) {
			boolean o1 = true;
			boolean x1 = true;
			for (int j = 0; j < 4; j++) {
				if (o1 && (fxf[i][j] == 'O' || fxf[i][j] == 'T')) {
					o1 = true;
				} else {
					o1 = false;
				}

				if (x1 && (fxf[i][j] == 'X' || fxf[i][j] == 'T')) {
					x1 = true;
				} else {
					x1 = false;
				}

			}

			if (o1) {
				return 'O';
			} else if (x1) {
				return 'X';
			}
		}

		// 세로 4개
		for (int j = 0; j < 4; j++) {
			boolean o1 = true;
			boolean x1 = true;
			for (int i = 0; i < 4; i++) {
				if (o1 && (fxf[i][j] == 'O' || fxf[i][j] == 'T')) {
					o1 = true;
				} else {
					o1 = false;
				}

				if (x1 && (fxf[i][j] == 'X' || fxf[i][j] == 'T')) {
					x1 = true;
				} else {
					x1 = false;
				}

			}

			if (o1) {
				return 'O';
			} else if(x1){
				return 'X';
			}
		}

		// 대각선 오른쪽 아래
		boolean o3 = true;
		boolean x3 = true;
		for (int i = 0; i < 4; i++) {
			if (o3 && (fxf[i][i] == 'O' || fxf[i][i] == 'T')) {
				o3 = true;
			} else {
				o3 = false;
			}

			if (x3 && (fxf[i][i] == 'X' || fxf[i][i] == 'T')) {
				x3 = true;
			} else {
				x3 = false;
			}
		}
		if (o3) {
			return 'O';
		} else if (x3) {
			return 'X';
		}

		// 대각선 오른쪽 위
		boolean o4 = true;
		boolean x4 = true;
		for (int i = 0; i < 4; i++) {
			if (o4 && (fxf[4 - 1 - i][i] == 'O' || fxf[4 - 1 - i][i] == 'T')) {
				o4 = true;
			} else {
				o4 = false;
			}

			if (x4 && (fxf[4 - 1 - i][i] == 'X' || fxf[4 - 1 - i][i] == 'T')) {
				x4 = true;
			} else {
				x4 = false;
			}
		}
		if (o4) {
			return 'O';
		} else if (x4) {
			return 'X';
		}

		return 'T';
	}

	public static boolean IsFull() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (fxf[i][j] == '.')
					return false;
			}
		}
		return true;
	}

}
