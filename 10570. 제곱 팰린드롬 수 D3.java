import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 10570. ���� �Ӹ���� �� D3
public class Solution {
	private static List<Integer> square_numbers = new ArrayList<Integer>();
	private static boolean[] palindrome_boolean_array = null;
	private static int N = 0;
	
	public static void main(String[] args) {

		while(N * N <= 1000) {
			square_numbers.add(N * N);
			N++;
		}
		
		// A ~ B ������ ���� ������ ��� �Ӹ�������� �Ǵ�
		// A, B�� �ִ밡 1000�̹Ƿ� �����ٱ��� �Ӹ������ ���� ���� �幰�� ������ �̸� �迭�� ������ �� �ִ�.
		palindrome_boolean_array = new boolean[N];
		palindrome_boolean_array[1] = true;
		palindrome_boolean_array[2] = true;
		palindrome_boolean_array[3] = true;
		palindrome_boolean_array[11] = true;
		palindrome_boolean_array[22] = true;
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			int answer = 0;
			for (int i = 0; i < N; i++) {
				if(A <= square_numbers.get(i) && B >= square_numbers.get(i)) {
					if (palindrome_boolean_array[i]) {
						answer++;
					}
				}
			}
			System.out.println("#" + t + " " + answer);
		}
	}

}
