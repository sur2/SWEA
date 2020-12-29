import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 1227. [S/W �����ذ� �⺻] 7���� - �̷�2 D4
public class Solution {

	public static int N = 100;
	
	// �� �� �� �� (������ �Ʒ��� ��ü�� �������� �ֱ� ������ ���� �켱�� �����Ѵ�.)
	public static int[] dY = {0, 1, 0, -1}; // i �� 
	public static int[] dX = {1, 0, -1, 0}; // j ��
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			int test = Integer.parseInt(sc.nextLine());
			
			int[][] arr = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String input = sc.nextLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = input.charAt(j) - '0';
				}
			}
			
			int answer = BFS(arr, 1, 1) ? 1 : 0;
			System.out.println("#" + test + " " + answer);
		}
	}
	
	private static boolean BFS(int[][] arr, int start_i, int start_j) {
		
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visit = new boolean[N][N];
		
		queue.offer(new int[] {start_i, start_j});
		visit[start_i][start_j] = true;

		while(!queue.isEmpty()) {
			
			int[] poll = queue.poll();
			int poll_i = poll[0];
			int poll_j = poll[1];
			
			// �� �� �� �� ���� �켱���� �׷��� Ž��(BFS)
			for (int d = 0; d < 4; d++) {
				int next_i = poll_i + dY[d];
				int next_j = poll_j + dX[d];
				// �������� �����ߴٸ� �׷��� Ž�� ����
				if(arr[next_i][next_j] == 3) {
					return true;
				}
				if(arr[next_i][next_j] == 0 && visit[next_i][next_j] == false) {
					queue.offer(new int[] {next_i, next_j});
					visit[next_i][next_j] = true;
				}
			}
		}
		
		return false;
	}

}
