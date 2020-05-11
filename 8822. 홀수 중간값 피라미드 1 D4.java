import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

// 8822. 홀수 중간값 피라미드 1 D4
public class Solution {

	private static int T = 0;
	private static int N = 0;
	private static int X = 0;
	
	private static BufferedReader br = null;
	private static BufferedWriter bw = null;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T + 1; t++) {
			String input = br.readLine();
			N = Integer.parseInt(input.split(" ")[0]);
			X = Integer.parseInt(input.split(" ")[1]);
			
			int max = 2 * N - 1;
			
			int result = X > 1 && X < max ? 1 : 0;
			
			bw.write("#" + t + " " + result + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
