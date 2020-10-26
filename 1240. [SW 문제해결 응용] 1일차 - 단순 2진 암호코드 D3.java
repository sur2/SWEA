import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 1240. [SW 문제해결 응용] 1일차 - 단순 2진 암호코드 D3
public class Solution {
	private static BufferedReader br = null;
	private static BufferedWriter bw = null;

	private static String STR0 = "0001101";
	private static String STR1 = "0011001";
	private static String STR2 = "0010011";
	private static String STR3 = "0111101";
	private static String STR4 = "0100011";
	private static String STR5 = "0110001";
	private static String STR6 = "0101111";
	private static String STR7 = "0111011";
	private static String STR8 = "0110111";
	private static String STR9 = "0001011";

	public static void main(String[] args) throws NumberFormatException, IOException {

		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		StringBuilder output = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			String temp = "";
			for (int n = 0; n < N; n++) {
				String in = br.readLine();
				for (int i = 0; i < M; i++) {
					if (in.charAt(M - 1 - i) == '1') {
						if (M - 1 - i > 54) {
							temp = in.substring(M - i - 1 - 55, M - i);
						}
						break;
					}
				}
				
			}

			StringBuilder result = new StringBuilder();

			for (int i = 0; i < 8; i++) {
				String tmp = temp.substring(i * 7, i * 7 + 7);
				if (STR0.equals(tmp)) {
					result.append(0);
				} else if (STR1.equals(tmp)) {
					result.append(1);
				} else if (STR2.equals(tmp)) {
					result.append(2);
				} else if (STR3.equals(tmp)) {
					result.append(3);
				} else if (STR4.equals(tmp)) {
					result.append(4);
				} else if (STR5.equals(tmp)) {
					result.append(5);
				} else if (STR6.equals(tmp)) {
					result.append(6);
				} else if (STR7.equals(tmp)) {
					result.append(7);
				} else if (STR8.equals(tmp)) {
					result.append(8);
				} else if (STR9.equals(tmp)) {
					result.append(9);
				}
			}
			
			String strResult = result.toString();
			int iResult = (strResult.charAt(0) - '0' + strResult.charAt(2) - '0' + strResult.charAt(4) - '0' + strResult.charAt(6) - '0') * 3
					+ strResult.charAt(7) - '0' + strResult.charAt(5) - '0' + strResult.charAt(3) - '0' + strResult.charAt(1) - '0';
			
			int re = 0;
			if (iResult % 10 == 0) {
				for (int i = 0; i < 8; i++) {
					re += strResult.charAt(i) - '0';
				}
			}
			output.append(String.format("#%d %d\n", t, re));
		}
		br.close();
		bw.write(output.toString());
		bw.flush();
		bw.close();
	
	}
}
