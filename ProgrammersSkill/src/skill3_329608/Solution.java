package skill3_329608;

import java.util.TreeMap;

public class Solution {
	public int[] solution(String[] operations) {
		int[] answer = new int[2];
		TreeMap<Integer, Integer> queue = new TreeMap<Integer,Integer>();
		for(String operation : operations) {
			String[] strs = operation.split(" ");
			if(strs[0].equals("I")) { // 입력
				queue.put(Integer.parseInt(strs[1]), 0);
			} else { // 삭제
				if(strs[1].equals("1")) { // 최대값 삭제
					queue.pollLastEntry();
				} else { // 최솟값 삭제
					queue.pollFirstEntry();
				}
			}
		}
		if(queue.size() == 0) {
			answer[0] = answer[1] = 0;
		} else {
			answer[0] = queue.pollLastEntry().getKey();
			answer[1] = queue.pollFirstEntry().getKey();
		}
		return answer;
	}
}
