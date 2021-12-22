package programmers.level2.c43165;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	public int solution(int[] numbers, int target) {
		Queue<Integer> que = new LinkedList<Integer>();
		int answer = 0;
		int size = numbers.length;
		que.add(numbers[0]);
		que.add(-numbers[0]);

		for (int i = 1; i < size; i++) {
			for(int j = 0; j < Math.pow(2, i); j++) {
				int tempNum = que.poll();
				int plus = tempNum + numbers[i];
				int minus = tempNum - numbers[i];
				if(i == size - 1) {
					if(plus == target) {
						answer++;
					}
					if(minus == target) {
						answer++;
					}
				} else {
					que.add(plus);
					que.add(minus);
				}
			}
		}

		return answer;
	}
}
