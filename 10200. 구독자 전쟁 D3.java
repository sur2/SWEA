import java.util.Scanner;

// 10200. 구독자 전쟁 D3
public class Solution {
	
	private static int T = 0;
	private static int N = 0;
	private static int A = 0;
	private static int B = 0;
	
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		T = sc.nextInt();
		sc.nextLine();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			A = sc.nextInt();
			B = sc.nextInt();
			
			int max = 0, min = 0;
			max = Math.min(A, B);
			min = A + B > N ? A + B - N : 0;
		
			System.out.println("#" + t + " " + max + " " + min);
		}
	}

}
