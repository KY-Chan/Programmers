package programmers.level2.c86052;

import java.util.Arrays;
import java.util.PriorityQueue;

// 빛의 경로 사이클
public class Solution {
	public int[] solution(String[] grid) {
		PriorityQueue<Integer> cycleLength = new PriorityQueue<Integer>();
		int m = grid.length;
		int n = grid[0].length();
		// 1 : 상, 2 : 우, 4 : 하, 8 : 좌
		int[][] direction = { {}, { -1, 0 }, { 0, 1 }, {}, { 1, 0 }, {}, {}, {}, { 0, -1 } };
		int[][] node = new int[m][n];
		char[][] cg = new char[m][n];
		for (int i = 0; i < m; i++) {
			Arrays.fill(node[i], 15);
			cg[i] = grid[i].toCharArray();
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (node[i][j] > 0) {
					for (int d = 1; d < 16; d <<= 1) {
						int curD = rotate(d, cg[i][j]);
						int[] curN = { i, j };
						int[] startN = { i, j };
						int length = 0;

						while ((node[curN[0]][curN[1]] & curD) == curD) { // 진행 가능 여부 확인
							length++;
							node[curN[0]][curN[1]] -= curD; // 방문함
							curN[0] = curN[0] + direction[curD][0];
							if (curN[0] < 0) {
								curN[0] = m - 1;
							} else if (curN[0] == m) {
								curN[0] = 0;
							}
							curN[1] = curN[1] + direction[curD][1];
							if (curN[1] < 0) {
								curN[1] = n - 1;
							} else if (curN[1] == n) {
								curN[1] = 0;
							}
							curD = rotate(curD, cg[curN[0]][curN[1]]);
						}
						if (length > 0) {
							cycleLength.add(length);
						}
					}

				}
			}
		}
		int[] answer = new int[cycleLength.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = cycleLength.poll();
		}
		return answer;
	}

	public int rotate(int d, char g) {
		if (g == 'L') {
			return d == 1 ? 8 : d >> 1;
		} else if (g == 'R') {
			return d == 8 ? 1 : d << 1;
		} else {
			return d;
		}
	}
}
