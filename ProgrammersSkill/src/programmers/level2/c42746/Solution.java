package programmers.level2.c42746;

import java.util.PriorityQueue;

// 가장 큰 수
public class Solution {
	public String solution(int[] numbers) {
		String answer = "";
		PriorityQueue<Integer> que = new PriorityQueue<Integer>((n1, n2) -> compareMagic(n1,n2));
		
		for(int n : numbers) {
			que.add(n);
		}
		if(que.peek() == 0) {
			return "0";
		}
		while(!que.isEmpty()) {
			answer += que.poll();
		}
		return answer;
	}

	public int compareMagic(int n1, int n2) {
		String num1 = n1 + "" + n2;
		String num2 = n2 + "" + n1;
		return num2.compareTo(num1);
	}
}
