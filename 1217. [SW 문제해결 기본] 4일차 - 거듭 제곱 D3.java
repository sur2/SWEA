import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 1217. [S/W ¹®Á¦ÇØ°á ±âº»] 4ÀÏÂ÷ - °Åµì Á¦°ö D3
public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = 10;
		int N, M;
		
		StringBuilder sb = new StringBuilder("");
		
		for (int t = 1; t <= T; t++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			sb.append("#");
			sb.append(t);
			sb.append(" ");
			sb.append(pow(N, M));
			sb.append('\n');
		}
		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	
	// Àç±ÍÇÔ¼ö·Î °ÅµìÁ¦°ö ¿¬»ê
	public static int pow(int n, int m) {
		if (m == 0) {
			return 0;
		}
		if (m == 1) {
			return n;
		} 
		return pow(n, m - 1) * n;
	}

}
