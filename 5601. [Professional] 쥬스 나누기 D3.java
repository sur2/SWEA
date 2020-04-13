import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 5601. [Professional] 쥬스 나누기 D3
public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t < T + 1; t++) {
			int N = Integer.parseInt(br.readLine());
			
			bw.write("#"+t+" ");
			for (int i = 0; i < N; i++) {
				bw.write("1/"+N+" ");
			}
			bw.write("\r\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
