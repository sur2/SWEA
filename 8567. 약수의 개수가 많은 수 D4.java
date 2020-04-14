import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// 8567. 약수의 개수가 많은 수 D4
public class Solution {

	private static int T = 0;
	private static int N = 0;
	private static int count = 0;
	private static int[] array = null;
	private static Scanner sc = null;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			array = new int[N + 1];
			for (int n = 1; n <= N; n++) {
				count = 1;
				division(n, 1);
				array[n] = count;
//				System.out.print(n + " ");
			}
//			System.out.println();
//			System.out.println(Arrays.toString(array));
			System.out.println("#" + t + " " + maxNumber());
		}
	}

	private static void division(int limit, int operand) {
		if (operand > limit / 2) {
			return;
		}
		if (limit % operand == 0) {
			count++;
			operand++;
			division(limit, operand);
		} else {
			operand++;
			division(limit, operand);
		}
	}

	private static int maxNumber() {
		int max = 0;
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			if (max <= array[i]) {
				max = array[i];
				index = i;
			}
		}
		return index;
	}

}
