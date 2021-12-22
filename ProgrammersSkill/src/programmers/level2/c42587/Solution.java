package programmers.level2.c42587;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
	public int solution(int[] priorities, int location) {
		int[] results = new int[priorities.length];
		Queue<pair> que = new LinkedList<pair>();
		PriorityQueue<Integer> max = new PriorityQueue<Integer>(Collections.reverseOrder());
		for(int idx = 0; idx < priorities.length; idx++) {
			que.add(new pair(idx, priorities[idx]));
			max.add(priorities[idx]);
		}
		int order = 1;
		while(!que.isEmpty()) {
			pair check = que.poll();
			if(check.getNumber() == max.peek()) {
				results[check.getIndex()] = order++;
				max.poll();
			} else {
				que.add(check);
			}
		}
		int answer = results[location];
		return answer;
	}
	public class pair {
		private int index;
		private int number;
		public pair(int index, int number) {
			this.index = index;
			this.number = number;
		}
		public int getIndex() {
			return index;
		}
		public int getNumber() {
			return number;
		}
	}
}
