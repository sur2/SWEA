import java.util.Scanner;

// 1979. ��� �ܾ �� �� ������ D2
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t < T + 1; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			// ������, �Ʒ��� �� ĭ �� �÷��� �迭�� ���� �������� ����
			int[][] arr = new int[N + 1][N + 1];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
				sc.nextLine();
			}
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(arr[i][j] == 1) {
						// ������ ������ K���� Ȯ��
						if(j - 1 >= 0 && arr[i][j - 1] == 0) {
							cnt += SearchR(K, i, j, arr);
						}else if(j == 0){
							cnt += SearchR(K, i, j, arr);
						}
						// �Ʒ� ������ K���� Ȯ��
						if(i - 1 >= 0 && arr[i - 1][j] == 0) {
							cnt += SearchD(K, i, j, arr);
						}else if(i == 0) {
							cnt += SearchD(K, i, j, arr);
						}
						
					}
				}
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}
	
	// ������ ������ Ȯ���Ǿ��ٸ� Ƚ�� ����
	public static int SearchR(int K, int i, int j, int[][] arr) {
		int l = 1;
		for (l = 1; l < K; l++) {
			if(arr[i][j + l] != 1) {
				return 0;
			}
		}
		
		if(arr[i][j + l] == 0) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	// �Ʒ� ������ Ȯ���Ǿ��ٸ� Ƚ�� ����
	public static int SearchD(int K, int i, int j, int[][] arr) {
		int l = 1;
		for (l = 1; l < K; l++) {
			if(arr[i + l][j] != 1) {
				return 0;
			}
		}
		
		if(arr[i + l][j] == 0) {
			return 1;
		}
		else {
			return 0;
		}
	}

}
