package programmers.level3.c49191;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// ¼øÀ§
// bfs
public class Solution {
	public int solution(int n, int[][] results) {
		int answer = 0;
		List<List<Integer>> win = new ArrayList<List<Integer>>();
		List<List<Integer>> lose = new ArrayList<List<Integer>>();
		for (int i = 0; i <= n; i++) {
			win.add(new ArrayList<Integer>());
			lose.add(new ArrayList<Integer>());
		}

		for (int[] result : results) {
			win.get(result[0]).add(result[1]);
			lose.get(result[1]).add(result[0]);
		}

		for(int i = 1; i <= n; i++) 
			if(n - 1 == getPoint(win, i, n) + getPoint(lose, i, n))
				answer++;
		
		return answer;
	}

	public int getPoint(List<List<Integer>> matches, int player, int n) {
		int point = 0;
		boolean[] visited = new boolean[n + 1];
		visited[player] = true;
		Queue<Integer> que = new LinkedList<Integer>();
		for(int foe : matches.get(player))  {
			que.add(foe);
			visited[foe] = true;
		}
		while (!que.isEmpty()) {
			int cur = que.poll();
			point++;
			for(int foe : matches.get(cur)) {
				if(!visited[foe]) {
					que.add(foe);
					visited[foe] = true;
				}
			}
		}
		return point;
	}
}
