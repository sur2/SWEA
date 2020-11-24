import java.util.Scanner;

// 2001. 파리 퇴치 D2
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			sc.nextLine();

			int max = 0;

			int arr[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
				sc.nextLine();
			}
			// 파리채가 들어갈 수 있는 범위에서 순회
			for (int n = 0; n <= N - M; n++) {
				for (int nn = 0; nn <= N - M; nn++) {
					int temp = 0;
					// 파리채 범위에서 모든 합 구하기
					for (int s = 0; s < M; s++) {
						for (int ss = 0; ss < M; ss++) {
							temp += arr[n + s][nn + ss];
						}
					}
					if (temp >= max) {
						max = temp;
					}
				}

			}

			System.out.println("#" + t + " " + max);
		}

	}

}
