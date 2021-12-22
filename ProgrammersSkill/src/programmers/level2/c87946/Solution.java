package programmers.level2.c87946;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public int solution(int k, int[][] dungeons) {
        int answer = 0;
        int[][] plans = new int[dungeons.length][2];
        for(int i = 0; i < plans.length; i++) {
        	plans[i][0] = 1 << i;
        	plans[i][1] = k - dungeons[i][1];
        }
        Queue<int[]> que = new LinkedList<int[]>();
        for(int[] plan : plans)
        	que.add(plan);
        
        while(!que.isEmpty()) {
        	int[] curPlan = que.poll();
        	boolean exhaustion = true;
        	for(int i = 0; i < dungeons.length; i++) {
        		if((curPlan[0] & (1 << i)) == 0) {
        			if(curPlan[1] >= dungeons[i][0]) {
        				int[] nextPlan = {curPlan[0] + (1 << i), curPlan[1] - dungeons[i][1]};
        				que.add(nextPlan);
        				exhaustion = false;
        			}
        		}
        	}
        	if(exhaustion) {
        		int complete = 0;
        		for(int i = 0; i < dungeons.length; i++)
        			if((curPlan[0] & (1 << i)) != 0)
        				complete++;
        		answer = answer > complete ? answer : complete;
        	}
        }
        return answer;
    }
}
