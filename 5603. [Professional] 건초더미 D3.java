import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 5603. [Professional] 건초더미 D3
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t < T + 1; t++) {
			int N = Integer.parseInt(br.readLine());
			int sum = 0;
			int[] arr = new int[N];
			for (int n = 0; n < N; n++) {
				int input = Integer.parseInt(br.readLine());
				arr[n] = input;
				sum += input;
			}
			int avg = sum / N;
			int result = 0;
			for (int n = 0; n < N; n++) {
				if (avg > arr[n]) {
					result += (avg - arr[n]);
				}
			}
			bw.write("#" + t + " " + result + "\r\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
