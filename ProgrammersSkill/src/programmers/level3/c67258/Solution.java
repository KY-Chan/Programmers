package programmers.level3.c67258;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// 보석 쇼핑
public class Solution {
	public int[] solution(String[] gems) {
		// 보석 종류 구하기
		Map<String, Integer> gemMap = new HashMap<String, Integer>();
		for (String gem : gems)
			gemMap.putIfAbsent(gem, 0);
		int types = gemMap.size();
		gemMap.clear();

		int[] answer = {1, gems.length};
		int start = 1;
		int end = 0;

		Queue<String> gemQue = new LinkedList<String>();
		for (int idx = 0; idx < gems.length; idx++) {
			// 1. 맨 앞 보석과 같은 보석이 나오면 맨 앞 보석 삭제
			while (gems[idx].equals(gemQue.peek())) {
				gemMap.compute(gemQue.poll(), (k, v) -> v - 1);
				start++;
			}
			// 2. 이후 맨 앞 보석이 이미 여러개 존재하는 경우 삭제
			while(gemMap.getOrDefault(gemQue.peek(), 0) > 1) {
				gemMap.compute(gemQue.poll(), (k, v) -> v - 1);
				start++;
			}
			// 3. 보석 추가
			gemMap.merge(gems[idx], 1, (total, add) -> total + add);
			gemQue.add(gems[idx]);
			end++;
			// 4. 모든 보석을 구매한 최소 구간
			if (gemMap.size() == types) {
				if(answer[1] - answer[0] > end - start) {
					answer[0] = start;
					answer[1] = end;
				}
			}
		}
		return answer;
	}
}
