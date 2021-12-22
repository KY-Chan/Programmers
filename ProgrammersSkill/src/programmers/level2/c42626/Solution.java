package programmers.level2.c42626;

import java.util.PriorityQueue;

public class Solution {
	public int solution(int[] scoville, int K) {
		PriorityQueue<Integer> scovs = new PriorityQueue<>();
		int answer = 0;
		for(int idx = 0; idx < scoville.length; idx++) {
			scovs.add(scoville[idx]);
		}
		while(scovs.size() > 1) {
			int left = scovs.poll();
			if(left >= K) {
				break;
			}
			answer++;
			int right = scovs.poll();
			int newScov = left + 2 * right;
			scovs.add(newScov);
		}
		if(scovs.poll() < K) {
			answer = -1;
		}
		return answer;
	}
}
