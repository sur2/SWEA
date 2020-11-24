import java.util.Scanner;

// 2001. �ĸ� ��ġ D2
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
			// �ĸ�ä�� �� �� �ִ� �������� ��ȸ
			for (int n = 0; n <= N - M; n++) {
				for (int nn = 0; nn <= N - M; nn++) {
					int temp = 0;
					// �ĸ�ä �������� ��� �� ���ϱ�
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
