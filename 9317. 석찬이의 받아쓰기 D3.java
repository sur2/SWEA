import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// 9317. 석찬이의 받아쓰기 D3
public class Solution {
	
	private static int T = 0;
	private static int N = 0;
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int n = N;
			int count = 0;
			Stack<Character> stack =new Stack<Character>();
			
			String word = br.readLine();
			String word2 = br.readLine();
			
			while(N-- != 0) {
				stack.push(word.charAt(N));
			}
			for (int i = 0; i < n; i++) {
				if (word2.charAt(i) == stack.pop()) {
					count++;
				}
			}
//			System.out.println(count);
			bw.write("#"+t+" "+count+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
