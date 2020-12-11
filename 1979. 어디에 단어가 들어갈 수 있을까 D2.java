import java.util.Scanner;

// 1979. 어디에 단어가 들어갈 수 있을까 D2
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t < T + 1; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			// 오른쪽, 아래쪽 한 칸 씩 늘려서 배열의 막힌 공간임을 구분
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
						// 오른쪽 공간이 K인지 확인
						if(j - 1 >= 0 && arr[i][j - 1] == 0) {
							cnt += SearchR(K, i, j, arr);
						}else if(j == 0){
							cnt += SearchR(K, i, j, arr);
						}
						// 아래 공간이 K인지 확인
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
	
	// 오른쪽 공간이 확보되었다면 횟수 증가
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
	
	// 아래 공간이 확보되었다면 횟수 증가
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
