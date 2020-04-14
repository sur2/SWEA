import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 9700. USB 꽂기의 미스터리 D3
public class Solution {

	private static BufferedReader br = null;
	private static BufferedWriter bw = null;
	private static int T = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t < T + 1; t++) {
			String input[] = br.readLine().split(" ");
			float p = Float.parseFloat(input[0]);
			float q = Float.parseFloat(input[1]);
			
			// s1은 한 번 뒤집었을 때 제대로 꽂힘 = 처음부터 뒤집은 방향으로 꽂음(1 - p) * 뒤집힌 후 올바르게 꽂음(q)
			float s1 = (1 - p) * q;
			// s2는 두 번 뒤집었을 때 제대로 꽂힘 = 처음부터 제대로된 방향(p) * 뒤집었지만 꽂히지 않음(1 - q) * 다시 뒤집어서 올바르게 꽂음(q)
			float s2 = p * (1 - q) * q;

			String result = s1 < s2 ? "YES" : "NO";
			bw.write("#" + t + " " + result + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
