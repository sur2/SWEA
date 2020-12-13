import java.util.Scanner;

// 1284. 수도 요금 경쟁 D2
public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int P = sc.nextInt();
			int Q = sc.nextInt();
			int R = sc.nextInt();
			int S = sc.nextInt();
			int W = sc.nextInt();
			
			int A = P * W;
			int B = Q;
			B += W > R ? (W - R) * S : 0;
			
			int result = A > B ? B : A;
			
			System.out.println("#" + t + " " + result);
					
		}
		
	}

}
