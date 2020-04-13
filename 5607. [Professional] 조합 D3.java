import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 5607. [Professional] 조합 D3
public class Solution {

	private static BufferedReader br;
	private static BufferedWriter bw;

	private static int T;
	private static int N;
	private static int R;

	private static final long p = 1234567891;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String input = br.readLine();

			N = Integer.parseInt(input.split(" ")[0]);
			R = Integer.parseInt(input.split(" ")[1]);

			// N! % p
			long A = factorialToModular(N, p);
			// ((N-R)! % p) (R! % p) % p
			long B = factorialToModular(N - R, p) * factorialToModular(R, p) % p;

			// AB^(p-2) % p
			long result = A * powToModular(B, p - 2, p) % p;

			bw.write("#" + t + " " + result + "\r\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

	// 나머지 연산의 곱셈 특징응 이용하여 팩토리얼의 나머지 구하기
	private static long factorialToModular(int n, long p) {
		long result = 1;
		if (n == 0) {
			return 1 % p;
		}
		// (1, 2, 3, ... n-1, n) % p
		// n * (n-1)! % p
		// ((n % p) (n-1)! % p) %p :: n! % p를 구하기 위해서는 (n-1)! % p를 구해하는 수학적 귀납법으로 해결
		for (int i = 1; i < n + 1; i++) {
			result *= i;
			result %= p;
		}
		return result;
	}

	// 재귀호출을 이용한 분할정복으로 나머지 연산
	private static long powToModular(long x, long y, long p) {
		long result = 1;
		if (y == 0) {
			return 1 % p;
		}
		// 분할정복
		// 2^5 = 2^2 * 2^2 * 2 (5 % 2 == 1)
		// 2^2 = 2 * 2 (2 % 2 == 0)
		result = powToModular(x, y / 2, p);
		if (y % 2 == 1) {
			return (x % p) * (result * result % p) % p;
		}
		return result * result % p;
	}

}
