package programmers.level2.c1844;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public int solution(int[][] maps) {
		int answer = 0;
		int m = maps.length;
		int n = maps[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (maps[i][j] == 1) {
					maps[i][j] = 1000;
				}
			}
		}
		
		int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

		Queue<int[]> que = new LinkedList<int[]>();
		int[] first = { 0, 0, 0 };
		que.add(first);
		maps[0][0] = 1;

		while (!que.isEmpty()) {
			int[] pos = que.poll();
			int y = pos[0];
			int x = pos[1];

			for (int[] d : direction) {
				int nextX = x + d[1];
				int nextY = y + d[0];
				if (nextX < n && nextY < m && nextX >= 0 && nextY >= 0) {
					// 벽에 막혀있지 않음
					if (maps[nextY][nextX] != 0) {
						// 이 경로가 기존 경로보다 저렴함
						if (maps[y][x] + 1 < maps[nextY][nextX]) {
							// que에 중복값이 들어가지 않게 미리 입력
							maps[nextY][nextX] = maps[y][x] + 1;
							int[] next = { nextY, nextX, maps[y][x]};
							que.add(next);
						}
					}

				}
			}
		}
		answer = maps[m-1][n-1];
		if(answer == 1000) {
			answer = -1;
		}
		return answer;
	}
}
