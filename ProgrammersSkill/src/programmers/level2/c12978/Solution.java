package programmers.level2.c12978;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {
	public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] distance = new int[N + 1];
        List<Map<Integer, Integer>> roads = new ArrayList<Map<Integer, Integer>>();
        for(int i = 0; i <= N; i++) {
        	distance[i] = 100000000;
        	roads.add(new HashMap<Integer, Integer>());
        }
        for(int[] r : road) {
        	roads.get(r[0]).merge(r[1], r[2], (oldV, newV) -> oldV < newV ? oldV : newV);
        	roads.get(r[1]).merge(r[0], r[2], (oldV, newV) -> oldV < newV ? oldV : newV);
        }
        
        
        Queue<int[]> que = new LinkedList<int[]>();
        int[] first = {1, 0};
        que.add(first);
        while(!que.isEmpty()) {
        	int[] cur = que.poll();
        	if(distance[cur[0]] > cur[1])
        		distance[cur[0]] = cur[1];
        	for(int village : roads.get(cur[0]).keySet()) {
        		if(distance[village] > cur[1] + roads.get(cur[0]).get(village)) {
        			distance[village] = cur[1] + roads.get(cur[0]).get(village);
        			int[] next = { village, distance[village]};
        			que.add(next);
        		}
        	}
        }
        
        for(int d : distance)
        	if(d <= K)
        		answer++;
        return answer;
    }
}
