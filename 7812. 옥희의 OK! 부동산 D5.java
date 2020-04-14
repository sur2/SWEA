import java.util.Scanner;

// 7812. 옥희의 OK! 부동산 D5
public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] arrN = new int[N];
			for (int i = 0; i < arrN.length; i++) {
				arrN[i] = sc.nextInt();
			}
			
			System.out.println("#"+t+" "+result(arrN, M));
		}

	}
	
	static int result(int[] arr, int m) {
		int count = 0;
		int sum = 0;
		int left = 0;
		int right = 0;
		while (true) {
			if (sum < m) {
				if (right == arr.length) {
					break;
				}
				sum += arr[right];
				right++;
			}
			else if (sum == m) {
				count++;
				if (right == arr.length) {
					break;
				}
				
				sum += arr[right];
				right++;
			}
			// sum > m
			else {
				sum -= arr[left];
				left++;
			}
			
		}
		return count;
	}
}
