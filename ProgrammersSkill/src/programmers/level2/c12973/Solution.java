package programmers.level2.c12973;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	public int solution(String s) {
		int answer = 0;
		Deque<Character> sc = new ArrayDeque<Character>();
		for(char c : s.toCharArray()) {
			int size = sc.size();
			if(size > 0) {
				if(sc.getLast() == c) {
					sc.pollLast();
					continue;
				}
			}
			sc.add(c);
		}
		if(sc.size() == 0) {
			answer = 1;
		}
		return answer;
	}
}
