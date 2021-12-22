package programmers.level3.c49189;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
// 가장 먼 노드
public class Solution {
	public int solution(int n, int[][] edge) {
		Map<Integer, List<Integer>> edgeMap = new HashMap<Integer, List<Integer>>();
		for (int i = 1; i <= n; i++)
			edgeMap.put(i, new ArrayList<Integer>());

		for (int[] e : edge) {
			edgeMap.get(e[0]).add(e[1]);
			edgeMap.get(e[1]).add(e[0]);
		}

		int answer = 0;
		int[] cost = new int[n + 1];
		Arrays.fill(cost, 100000);
		cost[0] = cost[1] = 0;
		Queue<int[]> que = new LinkedList<int[]>();
		int[] first = {1, 0};
		que.add(first);
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			for(int e : edgeMap.get(cur[0])) {
				if(cost[e] > cur[1] + 1) {
					cost[e] = cur[1] + 1;
					int[] next = {e, cur[1] + 1};
					que.add(next);
				}
			}
		}
		
		Arrays.sort(cost);
		int max = cost[n];
		for(int i = n; i >= 0; i--) {
			if(cost[i] != max) 
				break;
			answer++;
		}
		return answer;
	}
}
