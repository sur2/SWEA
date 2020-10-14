import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 1961. 숫자 배열 회전 D2
public class Solution {
	private static int N = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int arr[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N * 2 - 1; j++) {
					int temp = br.read() - '0';
					if (j % 2 == 0) {
						arr[i][j / 2] = temp;						
					}
				}
				br.readLine();
			}
			// 90도씩 3번 돌면 90, 180, 270도
			int[][] arr90 = GuShipDo(arr);
			int[][] arr180 = GuShipDo(arr90);
			int[][] arr270 = GuShipDo(arr180);
			/*
			printArr(arr90);
			printArr(arr180);
			printArr(arr270);
			*/
			sb.append(String.format("#%d\n", t));
			for (int n = 0; n < N; n++) {
				for (int i = 0; i < N; i++) {
					sb.append(arr90[n][i]);
				}
				sb.append(" ");
				for (int i = 0; i < N; i++) {
					sb.append(arr180[n][i]);
				}
				sb.append(" ");
				for (int i = 0; i < N; i++) {
					sb.append(arr270[n][i]);
				}
				sb.append("\n");
			}
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	// 확인용 출력 메서드
	public static void printArr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}		
	}
	
	// 90도 회전 메서드
	public static int[][] GuShipDo(int[][] arr) {
		int[][] gArr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				gArr[i][j] = arr[N - 1 - j][i];
			}
		}
		
		return gArr;
	}

}
