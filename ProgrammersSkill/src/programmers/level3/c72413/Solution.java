package programmers.level3.c72413;
// 합승 택시 요금
// 플로이드 와샬
public class Solution {
	public int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = 100000000;
		// 노드 초기화
		int[][] nodes = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				nodes[i][j] = 100000000;
			}
			nodes[i][i] = 0;
		}
		// 노드 입력
		for (int[] fare : fares) 
			nodes[fare[0]][fare[1]] = nodes[fare[1]][fare[0]] = fare[2];
		// 플로이드 와샬
		for (int pos = 1; pos <= n; pos++) { // 경유 지점
			for (int start = 1; start < n; start++) { // 시작 지점
				for (int end = start + 1; end < n + 1; end++) { // 끝 지점
					int bridge = nodes[start][pos] + nodes[pos][end];
					if(nodes[start][end] > bridge) 
						nodes[start][end] = nodes[end][start] = bridge;
				}
			}
		}
		// 최소값 계산
		for(int i = 1; i <= n; i++) {
			answer = Math.min(answer, nodes[s][i] + nodes[i][a] + nodes[i][b]);
		}
		return answer;
	}
}
