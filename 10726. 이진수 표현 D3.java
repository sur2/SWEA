import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 10726. 이진수 표현 D3
public class Solution {
	
	private static BufferedReader br = null;
	private static BufferedWriter bw = null;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long N = Long.parseLong(st.nextToken());
			long M = Long.parseLong(st.nextToken());
			
			N = (int) Math.pow(2, N) - 1;
			
			String out = "";
			
			if (N > M) {
				out = "OFF";
			}
			else if(N == M)
			{
				out = "ON";
			}
			else {
				// N개 비트를 다 켜고 난 후 남은 숫자(M - N)가 다음 비트 값(N + 1)에 나누어 떨어져야함
				if ((M - N) % (N + 1) == 0) {
					out = "ON";
				}
				else {
					out = "OFF";
				}
			}
			
			sb.append(String.format("#%d %s\n", t, out));
		}
		
		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
