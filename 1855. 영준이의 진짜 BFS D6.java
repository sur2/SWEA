import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

// 1855. 영준이의 진짜 BFS D6
public class Solution {

	public static int T;

	public static int N;

	public static final int MAX_DEPTH = 18;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		T = Integer.parseInt(br.readLine());

		List<List<Integer>> Tree = new ArrayList<List<Integer>>();
		List<Integer> search = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();

		for (int t = 1; t <= T; t++) {
			Tree.clear();
			search.clear();
			queue.clear();

			N = Integer.parseInt(br.readLine());

			int[] Depths;
			int[][] Parents;

			Depths = new int[N + 1];
			Parents = new int[N + 1][MAX_DEPTH + 1];

			// 트리 연결정보를 담을 배열 선언
			for (int n = 0; n <= N; n++) {
				Tree.add(new ArrayList<Integer>());
			}

			// 트리 연결정보 초기화
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int index = 2;
			while (st.hasMoreTokens()) {
				int tempNode = Integer.parseInt(st.nextToken());
				Tree.get(index).add(tempNode);
				Tree.get(tempNode).add(index);
				index++;
			}

			BFS(queue, search, Tree, Depths, Parents);
			SetParents(Parents);

			long length = 0;
			for (int i = 0; i < search.size() - 1; i++) {
				int node01 = search.get(i);
				int node02 = search.get(i + 1);
				int lca = LCA(node01, node02, Depths, Parents);
				length += (Depths[node01] - Depths[lca] + Depths[node02] - Depths[lca]);
			}

			// sb.append("#" + t + " " + length + "\n");
			bw.write("#" + t + " " + length + "\n");
			bw.flush();
		}

		/*
		 * bw.flush(); bw.write(sb.toString());
		 */

		bw.close();
		br.close();
	}

	public static List<Integer> BFS(Queue<Integer> queue, List<Integer> result, List<List<Integer>> Tree, int[] Depths,
			int[][] Parents) {
		boolean[] visits = new boolean[N + 1];
		queue.offer(1);

		// 인접한 노드를 조회하는 루프
		while (queue.isEmpty() == false) {
			int visitNode = queue.poll();
			visits[visitNode] = true;
			result.add(visitNode);

			int adjacencySize = Tree.get(visitNode).size();

			for (int i = 0; i < adjacencySize; i++) {
				int adjacencyNode = Tree.get(visitNode).get(i);
				if (visits[adjacencyNode] == false) {
					queue.offer(adjacencyNode);

					// 바로 위의 부모노드 저장
					Parents[adjacencyNode][0] = visitNode;
					// 깊이 저장
					Depths[adjacencyNode] = Depths[visitNode] + 1;
				}
			}
		}

		return result;
	}

	public static void SetParents(int[][] Parents) {
		// 각 노드들의 2^i승 위의 부모노드를 저장
		for (int i = 1; i <= MAX_DEPTH; i++) {
			for (int n = 1; n <= N; n++) {
				int halfParent = Parents[n][i - 1];
				Parents[n][i] = Parents[halfParent][i - 1];
			}
		}
	}

	public static int LCA(int nodeA, int nodeB, int[] Depths, int[][] Parents) {
		// 더 깊은 노드를 덜 깊은 노드와 같은 층으로 맞추어야 함.
		// 더 깊은 노드를 찾아서 보정(nodeA)
		if (Depths[nodeA] < Depths[nodeB]) {
			int temp = nodeA;
			nodeA = nodeB;
			nodeB = temp;
		}

		// 더 깊은 노드를 부모노드로 초기화하면서 깊이를 통일함.
		for (int i = MAX_DEPTH; i >= 0; i--) {
			long difference = Depths[nodeA] - Depths[nodeB];
			if (difference >= (1 << i)) {
				nodeA = Parents[nodeA][i];
			}
		}

		// 깊이를 맞추었을 때 두 노드가 같으면 공통 부모임.
		if (nodeA == nodeB) {
			return nodeA;
		}

		// 2^i를 큰 수부터 줄여가면서 조상노드를 조회
		// 조상노드끼리 다르다면 해당 조상노드로 갱신
		for (int i = MAX_DEPTH; i >= 0; i--) {
			if (Parents[nodeA][i] != Parents[nodeB][i]) {
				nodeA = Parents[nodeA][i];
				nodeB = Parents[nodeB][i];
			}
		}
		// 반복이 끝났으면 공통된 조상노드 직전까지 온 상태

		return Parents[nodeA][0];
	}

}