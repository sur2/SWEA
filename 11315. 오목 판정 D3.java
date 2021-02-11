import java.util.Scanner;

// 11315. 오목 판정 D3
public class Solution {
	public static Scanner sc;
	public static int T;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			sc.nextLine();
			char[][] array = new char[n + 2][n + 2];
			
			for (int i = 1; i <= n; i++) {
				String inputLine = sc.nextLine();
				for (int j = 1; j <= n; j++) {
					array[i][j] = inputLine.charAt(j - 1);
				}
			}
			
			//printArray(array, n);
			String result = findFiveLine(array, n) ? "YES" : "NO";
			
			System.out.println("#" + t + " " + result);
		}
	}
	
	public static boolean findFiveLine(char[][] array, int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (array[i][j] == 'o') {
					boolean is = true;
					// 하
					for (int k = 1; k < 5; k++) {
						if (array[i + k][j] != 'o') {
							is = false;
							break;
						}
					}
					if(is) {
						return true;
					}
					is = true;
					// 우하
					for (int k = 1; k < 5; k++) {
						if (array[i + k][j + k] != 'o') {
							is = false;
							break;
						}
					}
					if(is) {
						return true;
					}
					is = true;
					// 좌하
					for (int k = 1; k < 5; k++) {
						if (array[i + k][j - k] != 'o') {
							is = false;
							break;
						}
					}
					if(is) {
						return true;
					}
					is = true;
					// 좌
					for (int k = 1; k < 5; k++) {
						if (array[i][j - k] != 'o') {
							is = false;
							break;
						}
					}
					if(is) {
						return true;
					}
					is = true;
					// 우
					for (int k = 1; k < 5; k++) {
						if (array[i][j + k] != 'o') {
							is = false;
							break;
						}
					}
					if(is) {
						return true;
					}
					is = true;
				}
			}
		}
		return false;
	}
	
	
	public static void printArray(char[][] array, int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}

}
