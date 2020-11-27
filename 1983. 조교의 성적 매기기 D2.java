import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// 1983. ������ ���� �ű�� D2
public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			
			List<Double[]> list = new LinkedList<Double[]>();
			
			int N = sc.nextInt();
			int K = sc.nextInt();
			
			String answer = "";
			
			for (int n = 0; n < N; n++) {
				int MidtermExam = sc.nextInt();
				int Finals = sc.nextInt();
				int assignment = sc.nextInt();
				
				double total = MidtermExam * 0.35 + Finals * 0.45 + assignment * 0.2;
				// �Ҽ��� �� ° �ڸ� ���� ����
				//total = Math.round(total * 100) / 100.0;
				Double[] arr = {(double) (n + 1), total};
				list.add(arr);
			}
			
			// ���� ������ ��������
			list.sort((o1, o2) -> o1[1] < o2[1] ? 1 : -1);
			
			int num = 0;
			for (int i = 0; i < list.size(); i++) {
				//System.out.println(list.get(i)[0] + ", " + list.get(i)[1]);
				if(list.get(i)[0] == K) {
					//System.out.println(i + 1);
					// K�� ° �л��� ���
					num = i + 1;
				}
			}
			
			// 10��
			// ��� ��ŭ ���� �ű��
			if(N * 0.1 >= num) {
				answer = "A+";
			}
			else if(N * 0.2 >= num)
			{
				answer = "A0";
			}
			else if(N * 0.3 >= num)
			{
				answer = "A-";
			}
			else if(N * 0.4 >= num)
			{
				answer = "B+";
			}
			else if(N * 0.5 >= num)
			{
				answer = "B0";
			}
			else if(N * 0.6 >= num)
			{
				answer = "B-";
			}
			else if(N * 0.7 >= num)
			{
				answer = "C+";
			}
			else if(N * 0.8 >= num)
			{
				answer = "C0";
			}
			else if(N * 0.9 >= num)
			{
				answer = "C-";
			}
			else {
				answer = "D0";
			}
			
			System.out.println("#" + t + " " + answer);
			
		}
	}

}
