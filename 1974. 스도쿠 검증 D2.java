import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1974. 스도쿠 검증 D2
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int sudoku[][] = new int[9][9];

			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int j = 0;
				while (st.hasMoreTokens()) {
					sudoku[i][j] = Integer.parseInt(st.nextToken());
					j++;
				}
			}
			/*
			for (int i = 0; i < 9; i++) {
				System.out.println(Arrays.toString(sudoku[i]));
			}
			*/
			
			int result = RowPass(sudoku) * ColumnPass(sudoku) * ThreeByThree(sudoku);
			
			StringBuilder sb = new StringBuilder();
			sb.append(String.format("#%d %d\n", t, result));
			bw.write(sb.toString());
		}
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static int RowPass(int[][] sudoku) {
		for (int c = 0; c < 9; c++) {
			boolean check[] = new boolean[9];
			for (int r = 0; r < 9; r++) {
				check[sudoku[r][c] - 1] = true; 
			}
			
			for (int r = 0; r < 9; r++) {
				if (!check[r]) {
					return 0;
				}
			}
		}
		return 1;
	}
	
	private static int ColumnPass(int[][] sudoku) {
		for (int r = 0; r < 9; r++) {
			boolean check[] = new boolean[9];
			for (int c = 0; c < 9; c++) {
				check[sudoku[r][c] - 1] = true;
			}
			for (int c = 0; c < 9; c++) {
				if(!check[c]) {
					return 0;
				}
			}
		}
		return 1;
	}
	
	private static int ThreeByThree(int[][] sudoku) {
		for (int i = 0; i < 9; i++) {
			boolean check[] = new boolean[9];
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++) {
					check[sudoku[r][c] - 1] = true;
				}
			}
			
			for (int j = 0; j < 9; j++) {
				if(!check[j]) {
					return 0;
				}
			}
		}
		
		return 1;
	}
}
