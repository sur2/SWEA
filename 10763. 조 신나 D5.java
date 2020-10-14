import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 10763. Á¶ ½Å³ª D5
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder output = new StringBuilder("");
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			float result = 0f;
			String input = br.readLine();
			String[] strArr = input.split(" ");
			int index = 0;
			for (String string : strArr) {
				if (Integer.parseInt(string) != index + 1) {
					result++;
				}
				index++;
			}	
			
			output.append(String.format("#%d %.6f\n", t, result));
		}
		
		bw.write(output.toString());
		br.close();
		bw.flush();
		bw.close();
	}
}
