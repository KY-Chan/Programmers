package programmers.level3.c72413;
// �ս� �ý� ���
// �÷��̵� �ͼ�
public class Solution {
	public int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = 100000000;
		// ��� �ʱ�ȭ
		int[][] nodes = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				nodes[i][j] = 100000000;
			}
			nodes[i][i] = 0;
		}
		// ��� �Է�
		for (int[] fare : fares) 
			nodes[fare[0]][fare[1]] = nodes[fare[1]][fare[0]] = fare[2];
		// �÷��̵� �ͼ�
		for (int pos = 1; pos <= n; pos++) { // ���� ����
			for (int start = 1; start < n; start++) { // ���� ����
				for (int end = start + 1; end < n + 1; end++) { // �� ����
					int bridge = nodes[start][pos] + nodes[pos][end];
					if(nodes[start][end] > bridge) 
						nodes[start][end] = nodes[end][start] = bridge;
				}
			}
		}
		// �ּҰ� ���
		for(int i = 1; i <= n; i++) {
			answer = Math.min(answer, nodes[s][i] + nodes[i][a] + nodes[i][b]);
		}
		return answer;
	}
}
