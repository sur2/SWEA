import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 10761. ½Å·Ú D3
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String[] input = br.readLine().split(" ");
			Bot A = new Bot();
			Bot B = new Bot();
			
			int current_time = 0;
			
			for (int i = 1; i < input.length; i += 2) {
				if (input[i].equals("O")) {
					int move = Math.abs(A.btn_location - Integer.parseInt(input[i + 1]));
					int after_time = current_time - A.time;
					if(current_time == A.time) {
						A.time += move + 1;
						A.btn_location = Integer.parseInt(input[i + 1]);
						current_time = A.time;
					}
					else {
						if(after_time > move) {
							current_time++;
							A.time = current_time;
							A.btn_location = Integer.parseInt(input[i + 1]);
						}
						else {
							current_time += move - after_time + 1;
							A.time = current_time;
							A.btn_location = Integer.parseInt(input[i + 1]);
						}
					}
				}
				else if(input[i].equals("B")) {
					int move = Math.abs(B.btn_location - Integer.parseInt(input[i + 1]));
					int after_time = current_time - B.time;
					if(current_time == B.time) {
						B.time += move + 1;
						B.btn_location = Integer.parseInt(input[i + 1]);
						current_time = B.time;
					}
					else {
						if(after_time > move) {
							current_time++;
							B.time = current_time;
							B.btn_location = Integer.parseInt(input[i + 1]);
						}
						else {
							current_time += move - after_time + 1;
							B.time = current_time;
							B.btn_location = Integer.parseInt(input[i + 1]);
						}
					}
				}
			}
			bw.write("#" + t + " " + current_time + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}

class Bot {
	public int time = 0;
	public int btn_location = 1;
}
