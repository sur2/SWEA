import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 9611. 명진이와 동휘의 숫자 맞추기 D3
public class Solution {

	private static int[] arr = null;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t < T + 1; t++) {
			int N = Integer.parseInt(br.readLine());
			arr = new int[10];

			for (int i = 0; i < N; i++) {
				StringBuilder sb = new StringBuilder();
				sb.append(br.readLine());
				int len = sb.length();
				for (int j = 0; j < 8; j += 2) {
					int num = sb.charAt(j) - 48;
					if (sb.substring(8, len).equals("YES")) {
						arr[num] += 1;
					} else {
						arr[num] -= 1;
					}
				}
			}

			int max = Integer.MIN_VALUE;
			int index = 0;
			for (int j = 0; j < 10; j++) {
				if (arr[j] > max) {
					max = arr[j];
					index = j;
				}
			}
			bw.write("#" + t + " " + index + "\r\n");
			System.out.println(Arrays.toString(arr));
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
