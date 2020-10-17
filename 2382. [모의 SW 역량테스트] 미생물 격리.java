import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 2382. [모의 SW 역량테스트] 미생물 격리
public class Solution {
	private static BufferedReader br = null;
	private static BufferedWriter bw = null;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			String in = br.readLine();
			String[] input_split = in.split(" ");
			int N = Integer.parseInt(input_split[0]);
			int M = Integer.parseInt(input_split[1]);
			int K = Integer.parseInt(input_split[2]);

			Microorganism[][] arr = new Microorganism[N][N];

			int re = Sol(t, N, M, K, arr);
			sb.append(String.format("#%d %d\n", t, re));
		}
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();

	}

	// 1(상) 2(하) 3(좌) 4(우)
	private static int Sol(int t, int N, int M, int K, Microorganism[][] arr) throws IOException {
		int moveDir[][] = {
				// 상 하 좌 우
				{ 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		Microorganism[][] temp = new Microorganism[N][N];
		Microorganism[][] reset = new Microorganism[N][N];
		// Map Setting
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = new Microorganism();
				temp[i][j] = new Microorganism();
			}
		}

		for (int i = 0; i < K; i++) {
			String mi_in = br.readLine();
			String[] mi_spilt = mi_in.split(" ");
			// 세로 위치
			int row = Integer.parseInt(mi_spilt[0]);
			// 가로 위치
			int column = Integer.parseInt(mi_spilt[1]);
			// 미생물 수
			int micro = Integer.parseInt(mi_spilt[2]);
			// 이동방향
			int dir = Integer.parseInt(mi_spilt[3]);

			arr[row][column].direction = dir;
			arr[row][column].micros = micro;
			arr[row][column].max = micro;
		}
		// M시간 동안 움직임
		for (int mTime = 0; mTime < M; mTime++) {
			Move(arr, temp, N, moveDir, reset);
		}
		int cnt = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j].micros > 0) {
					cnt += arr[i][j].micros;
				}
			}
		}
		return cnt;
	}

	// 상 하 좌 우
	private static void Move(Microorganism[][] arr, Microorganism[][] temp, int N, int moveDir[][],
			Microorganism[][] reset) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				
				if (arr[i][j].micros > 0) {

					int row = i + moveDir[arr[i][j].direction][0];
					int col = j + moveDir[arr[i][j].direction][1];

					// 약품처리된 곳
					if (row == 0 || col == 0 || row == N - 1 || col == N - 1) {
						temp[row][col].micros = arr[i][j].micros / 2;
						temp[row][col].max = arr[i][j].micros/ 2;
						/*
						 * if (arr[i][j].direction % 2 == 0) { temp[row][col].direction =
						 * arr[i][j].direction - 1; } else if(arr[i][j].direction % 2 == 1){
						 * temp[row][col].direction = arr[i][j].direction + 1; }
						 */

						switch (arr[i][j].direction) {
							case 1:
								temp[row][col].direction = 2;
								break;
							case 2:
								temp[row][col].direction = 1;
								break;
							case 3:
								temp[row][col].direction = 4;
								break;
							case 4:
								temp[row][col].direction = 3;
								break;
							default:
								break;
						}
					}
					// 이동 가능
					else {
						// 미생물이 있다면
						if (temp[row][col].micros > 0) {
							temp[row][col].micros += arr[i][j].micros;
							// 더 큰 군집이 올 경우
							if (temp[row][col].max < arr[i][j].micros) {
								temp[row][col].max = arr[i][j].micros;
								temp[row][col].direction = arr[i][j].direction;
							}
						}
						// 미생물이 없다면
						else {
							temp[row][col].micros = arr[i][j].micros;
							temp[row][col].max = arr[i][j].micros;
							temp[row][col].direction = arr[i][j].direction;
						}
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j].micros = temp[i][j].micros;
				arr[i][j].max = temp[i][j].micros;
				arr[i][j].direction = temp[i][j].direction;
			}
		}
		for (int k = 0; k < N; k++) {
			for (int k2 = 0; k2 < N; k2++) {
				temp[k][k2].Death();
			}
		}
	}
}

class Microorganism {
	int direction = 0;
	int micros = 0;
	int max = 0;

	public Microorganism() {

	}

	public Microorganism(int direction, int micro, int max) {
		this.direction = direction;
		this.micros = micro;
		this.max = max;
	}

	@Override
	public String toString() {

		return this.micros + "";
	}

	public void Death() {
		this.direction = 0;
		this.micros = 0;
		this.max = 0;
	}
}