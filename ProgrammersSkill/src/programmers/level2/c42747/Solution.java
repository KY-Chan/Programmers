package programmers.level2.c42747;

import java.util.HashMap;
import java.util.Map;
// H-Index
public class Solution {
	public int solution(int[] citations) {
		int answer = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int cit : citations)
			map.merge(cit, 1, (total, plus) -> total + plus);
		int count = citations.length;

		for (int i = 1; i <= count; i++) {
			if(map.containsKey(i-1))
				count -= map.remove(i-1);
			if(count >= i)
				answer = i;
		}
		return answer;
	}
}