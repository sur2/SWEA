import java.util.Arrays;
import java.util.Scanner;

// 2383. [모의 SW 역량테스트] 점심 식사시간 
public class Solution {
	private static Scanner sc = new Scanner(System.in);
	private static int T = 0;
	private static int N = 0;
	private static int[][] Map = null;

	// 좌표를 저장할 객체
	private static class Point {
		int r = 0;
		int c = 0;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			System.out.print("[" + r + ", " + c + "] ");
			return "[" + r + ", " + c + "] ";
		}
	}

	// 사람과 계단의 위치를 담을 배열
	private static Point[] PeopleArr = null;
	private static Point[] StairArr = null;

	// 사람과 계단 수
	private static int People = 0;
	private static int Stair = 0;

	// 계단을 선택한 사람을 저장한 배열
	private static int Match[] = null;
	
	// 결과를 담을 변수
	private static int Result = 0;

	public static void main(String[] args) {
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			// 1부터 N번 좌표까지
			Map = new int[N + 1][N + 1];
			// 1부터 10명까지
			PeopleArr = new Point[11];
			People = 0;
			// 1부터 2번 계단까지
			StairArr = new Point[3];
			Stair = 0;
			Result = Integer.MAX_VALUE;
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					Map[i][j] = sc.nextInt();
					if (Map[i][j] == 1) {
						PeopleArr[++People] = new Point(i, j);
					}
					if (Map[i][j] > 1) {
						StairArr[++Stair] = new Point(i, j);
					}
				}
			}
			// 사람[People]이 선택한 계단[1 or 2]
			Match = new int[People + 1];
//			System.out.println(People);
//			Arrays.toString(PeopleArr);
//			System.out.println();
//			Arrays.toString(StairArr);
			recursiveDFS(1);
//			Match[1] = 1;
//			Match[2] = 1;
//			Match[3] = 1;
//			Match[4] = 1;
//			Match[5] = 2;
//			Match[6] = 2;
//			calculateTime();
			System.out.println("#"+t+" "+Result);
			
		}
	}

	// 사람이 계단을 선택할 경우의 수를 DFS로 찾기
	private static void recursiveDFS(int people_index) {
		if (people_index > People) {
//			for (int i = 0; i < Match.length; i++) {
//				System.out.print(Match[i]+" ");
//			}
//			System.out.println();
			if (Result > calculateTime()) {
				Result = calculateTime();
			};
			return;
		}
		Match[people_index] = 1;
		recursiveDFS(people_index + 1);
		Match[people_index] = 2;
		recursiveDFS(people_index + 1);
	}
	
	// 좌표 간의 거리로 이동시간 구하기
	private static int ABS(Point a, Point b) {
		return Math.abs(a.r - b.r) + Math.abs(a.c - b.c);
	}

	// 시간을 계산
	private static int calculateTime() {
		// 계단1과 2를 내려가는 사람의 수
		int stair1 = 0;
		int stair2 = 0;
		// 각 계단을 내려가는 시간
		int stair1time = Map[StairArr[1].r][StairArr[1].c];
		int stair2time = Map[StairArr[2].r][StairArr[2].c];
		// 각 사람 별 계단의 도착하는 시간
		int[] arrive_stair = new int[People + 1];
		for (int i = 1; i < arrive_stair.length; i++) {
			arrive_stair[i] = ABS(PeopleArr[i], StairArr[Match[i]]);
//			System.out.print(arrive_stair[i] + " ");
			if (Match[i] == 1) {
				stair1++;
			} else {
				stair2++;
			}
		}
		// 각 계단에 도착한 사람들의 시간을 저장
		int[] stair1Arr = new int[stair1 + 1];
		int[] stair2Arr = new int[stair2 + 1];
        int temp1 = 0, temp2 = 0;
		for (int i = 1; i < arrive_stair.length; i++) {
			if (Match[i] == 1) {
				stair1Arr[++temp1] = arrive_stair[i];
			} 
			if (Match[i] == 2) {
				stair2Arr[++temp2] = arrive_stair[i];
			}
		}
//		System.out.println();
//		System.out.println(stair1 + " " + stair2);
//		System.out.println(stair1time + " " + stair2time);
//		System.out.println(Arrays.toString(stair1Arr));
//		System.out.println(Arrays.toString(stair2Arr));
//
		Arrays.sort(stair1Arr);
		Arrays.sort(stair2Arr);
//		System.out.println(Arrays.toString(stair1Arr));
//		System.out.println(Arrays.toString(stair2Arr));

		// 각 계단의 모든 사람이 내려간 시간
		Stair1TotalTime = 0;
		Stair2TotalTime = 0;

		Stair1Action(stair1, stair1Arr, stair1time);
		Stair2Action(stair2, stair2Arr, stair2time);
//		System.out.println(Stair1TotalTime);
//		System.out.println(Stair2TotalTime);
//		System.out.println(">> "+Math.max(Stair1TotalTime, Stair2TotalTime));
		// 계단 1과 2중 오래 걸리는 것이 최종적으로 걸리는 시간
		return Math.max(Stair1TotalTime, Stair2TotalTime);
	}

	// 각 계단의 모든 사람이 내려간 시간
	private static int Stair1TotalTime = 0;
	private static int Stair2TotalTime = 0;

	// 각 계단 별 마지막 사람이 내려가는데 걸리는 시간 구하기
	private static void Stair1Action(int n, int[] stair1Arr, int stair1time) {
		// 계단에 도착한 사람이 3명이하 인 경우
		if (n < 4) {
			Stair1TotalTime = stair1Arr[n] + stair1time + 1;
			return;
		}
		// 계단에 도착한 사람이 4명 이상이면 마지막 사람(n)이 3명 이하가 될 때 까지 재귀(n - 3)
		Stair1Action(n - 3, stair1Arr, stair1time);
		// 계단에 도착한 시간에 사람이 없다면 도착한 시간부터 내려가는 시간까지 구하면 된다.
		if (Stair1TotalTime <= stair1Arr[n]) {
			Stair1TotalTime = stair1Arr[n] + stair1time + 1;
		}
		// 계단에 도착했는데 앞에 사람이 있다면 앞 사람이 지나간 후 계단이동 시간만큼만 더하면 된다.
		else {
			Stair1TotalTime += stair1time;
		}
	}
	
	// 계단 2도 똑간이 연산한다.
	private static void Stair2Action(int n, int[] stair2Arr, int stair2time) {
		if (n < 4) {
			Stair2TotalTime = stair2Arr[n] + stair2time + 1;
			return;
		}
		Stair2Action(n - 3, stair2Arr, stair2time);
		if (Stair2TotalTime <= stair2Arr[n]) {
			Stair2TotalTime = stair2Arr[n] + stair2time + 1;
		}
		else {
			Stair2TotalTime += stair2time;
		}
	}
}
