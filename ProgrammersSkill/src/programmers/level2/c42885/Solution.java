package programmers.level2.c42885;

import java.util.PriorityQueue;
// 구명보트
public class Solution {
	public int solution(int[] people, int limit) {
		int answer = 0;
		PriorityQueue<Integer> pig = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
		PriorityQueue<Integer> skel = new PriorityQueue<Integer>();
		for (int p : people) {
			if (p > limit >>> 1)
				pig.add(p);
			else
				skel.add(p);
		}
		System.out.println(pig);
		System.out.println(skel);
		while (!pig.isEmpty()) {
			if (!skel.isEmpty()) {
				if(pig.poll() + skel.peek() <= limit)
					skel.poll();
				answer++;
			} else {
				answer += pig.size();
				break;
			}
		}
		if(!skel.isEmpty()) {
			answer += skel.size() / 2;
			answer += skel.size() % 2;
		}
		return answer;
	}
}
