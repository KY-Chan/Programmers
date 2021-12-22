package programmers.level3.c42627;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
	public int solution(int[][] jobs) {
		int answer = 0;
		Queue<int[]> q = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
		int idx = 0;
		int curTime = 0;
		int size = jobs.length;
	
		while(idx < size || !q.isEmpty()) {
			while(idx < size && jobs[idx][0] <= curTime) {
				q.add(jobs[idx++]);
			}
			if(q.isEmpty()) {
				curTime = jobs[idx][0];
			} else {
				int[] job = q.poll();
				answer += curTime - job[0] + job[1];
				curTime += job[1];
			}
		}
		return answer / size;
	}
}
