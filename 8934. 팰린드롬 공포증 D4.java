import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 8934. 팰린드롬 공포증 D4
public class Solution {

	private static BufferedReader br = null;
	private static BufferedWriter bw = null;

	private static int T = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {

		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t < T + 1; t++) {
			int a = 0, b = 0, c = 0;
			int ab = 0, bc = 0, ac = 0;

			String input = br.readLine();
			
			// 입력받은 문자열 중 a, b, c의 각 개수 셈
			for (int i = 0; i < input.length(); i++) {
				switch (input.charAt(i)) {
				case 'a':
					a++;
					break;
				case 'b':
					b++;
					break;
				case 'c':
					c++;
					break;
				default:
					break;
				}

			}
			
			// 각 문자들의 a, b, c 간의 개수 차이
			ac = Math.abs(a - c);
			bc = Math.abs(b - c);
			ab = Math.abs(a - b);

			String output = "YES";
			
			// 팰린드롬 aa, bb, cc를 만들 수 있는 경우는 개수의 차이가 2이상 일 경우이다.
			if (ac > 1 || bc > 1 || ab > 1) {
				output = "NO";
			}
			
			bw.write("#" + t + " " + output + "\n");
			
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
