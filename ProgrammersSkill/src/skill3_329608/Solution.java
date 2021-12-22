package skill3_329608;

import java.util.TreeMap;

public class Solution {
	public int[] solution(String[] operations) {
		int[] answer = new int[2];
		TreeMap<Integer, Integer> queue = new TreeMap<Integer,Integer>();
		for(String operation : operations) {
			String[] strs = operation.split(" ");
			if(strs[0].equals("I")) { // �Է�
				queue.put(Integer.parseInt(strs[1]), 0);
			} else { // ����
				if(strs[1].equals("1")) { // �ִ밪 ����
					queue.pollLastEntry();
				} else { // �ּڰ� ����
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
