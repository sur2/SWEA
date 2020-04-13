import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 5604. [Professional] 구간 합 D4 
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t < T + 1; t++) {
			String input = br.readLine();
			String[] split = input.split(" ");
			long A = Long.parseLong(split[0]);
			long B = Long.parseLong(split[1]);
			// 0 ~ 9까지 담을 배열 : 구간에 포함되는 모든 정수의 자리 값을 저장
			long zeroToNine[] = new long[10];
			long total = 0;
			// 젤 왼쪽 자리 수 ex) 1의 자리, 10의 자리, 100의 자리...
			long digits = 1;
			if (A == 0) {
				A = 1;
			}
			while (A <= B) {
				// A와 B의 왼쪽 젤 끝 자리
				// ex) 33, 34, ... 40
				while (A <= B && A % 10 != 0) {
					calculate(A++, zeroToNine, digits);
				}
				if (A > B) {
					break;
				}
				// ex) 133, 132, 131, 130, 129
				while (A <= B && B % 10 != 9) {
					calculate(B--, zeroToNine, digits);
				}
				total += digits * (B / 10 - A / 10 + 1) * 45;
				A /= 10;
				B /= 10;
				digits *= 10;
			}
			// 0 ~ 9까지 수의 모든 합
			for (int i = 0; i < 10; i++) {
				total += zeroToNine[i] * i;
			}

			bw.write("#" + t + " " + total + "\r\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

	// 숫자가 가지는 각 자리 수를 담는 배열(기준 숫자, 0 ~ 9까지 각 자리 수, 시작되는 n의 자리수)
	private static void calculate(long number, long zeroToNine[], long n) {
		while (number > 0) {
			int num = (int) (number % 10);
			// 해당 숫자가 있으면 1씩 추가한다.(개수)
			zeroToNine[num] += (1 * n);
			number /= 10;
		}
	}
}
