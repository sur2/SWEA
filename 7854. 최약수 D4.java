import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 7854. 최약수 D4
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 1,000,000,000 최약수 모음
		int arr[] = new int[43 + 1];
		
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 5;
		
		arr[4] = 10;
		arr[5] = 20;
		arr[6] = 25;
		arr[7] = 50;
		
		arr[8] = 100;
		arr[9] = 125;
		arr[10] = 200;
		arr[11] = 250;
		arr[12] = 500;
		
		for (int i = 13; i < 42; i+=5) {
			arr[i] = arr[i - 5] * 10; 
			arr[i + 1] = arr[i - 4] * 10; 
			arr[i + 2] = arr[i - 3] * 10; 
			arr[i + 3] = arr[i - 2] * 10; 
			arr[i + 4] = arr[i - 1] * 10; 
		}
		
		arr[43] = 1000000000;
		
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			int X = Integer.parseInt(br.readLine());
			
			int index = 43;
			while(arr[index] > X)
			{
				index--;
			}
			
			sb.append("#" + t + " " + index + "\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.flush();
		bw.close();
	}

}
