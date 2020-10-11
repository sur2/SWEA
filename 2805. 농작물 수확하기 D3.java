import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 2805. ���۹� ��Ȯ�ϱ� D3
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int arr[][] = new int[N][N];
			for (int n = 0; n < N; n++) {
				String input = br.readLine();
				for (int nn = 0; nn < N; nn++) {
					arr[n][nn] = input.charAt(nn) - 48;
				}
			}
			/*
			for (int i = 0; i < N; i++) {
				System.out.println(Arrays.toString(arr[i]));
			}
			*/
			
			// ��Ȯ��
			int yield = 0;
			
			int line = N / 2;
			
			while(line > 0) {
				// �밢�� ���� �Ʒ�
				int r = 0 + (N / 2 - line);
				int c = N / 2;
				for (int i = 0; i < line; i++) {
					yield += arr[r][c];
					r++;
					c--;
				}
				// �밢�� ������ �Ʒ�
				r = N / 2;
				c = 0 + (N / 2 - line);
				for (int i = 0; i < line; i++) {
					yield += arr[r][c];
					r++;
					c++;
				}
				// �밢�� ������ ��
				r = N - 1 - (N / 2 - line);
				c = N / 2;
				for (int i = 0; i < line; i++) {
					yield += arr[r][c];
					r--;
					c++;
				}
				// �밢�� ���� ��
				r = N / 2;
				c = N - 1 - (N / 2 - line);
				for (int i = 0; i < line; i++) {
					yield += arr[r][c];
					r--;
					c--;
				}
				
				line--;
			}
			
			yield += arr[N / 2][N / 2];
			
			StringBuilder sb = new StringBuilder();
			sb.append(String.format("#%d %d\n", t, yield));
			
			bw.write(sb.toString());
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
