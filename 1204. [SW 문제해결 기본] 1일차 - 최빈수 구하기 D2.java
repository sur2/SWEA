import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 1204. [S/W 문제해결 기본] 1일차 - 최빈수 구하기 D2
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder output = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		int N = 0;
		int[] arr = new int[1000];
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			String in = br.readLine();
			
			int[] point = new int[101];
			
			StringToIntArr(point, in);
			
			int cnt = 0;
			int max = 0;
			for (int i = 0; i < point.length; i++) {
				int newIndex = point.length - 1 - i;
				if (point[newIndex] > max) {
					max = point[newIndex];
					cnt = newIndex;
				}
			}
			
			String nOut = String.format("#%d %d\n", t, cnt);
			output.append(nOut);
		}
		
		bw.write(output.toString());
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static void StringToIntArr(int[] point, String str) {
		String temp = "";
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ') {
				int index = Integer.parseInt(temp);
				point[index] += 1;
				temp = "";
			} else {
				temp += str.charAt(i);
			}
		}
	}

}
