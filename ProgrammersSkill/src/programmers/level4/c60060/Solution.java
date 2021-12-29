package programmers.level4.c60060;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int[] solution(String[] words, String[] queries) {
		Map<String, Integer> lyrics = new HashMap<String, Integer>();
		int[] answer = new int[queries.length];
		// map�� query�� �Է�, set�� query ���� �Է�
		for (String query : queries) 
			lyrics.putIfAbsent(query, 0);
		
		// word�� �����Ǵ� ������ ī��Ʈ �÷���
		for (String word : words) {
			lyrics.computeIfPresent(word, (key, value) -> value + 1);
			char[] forward = word.toCharArray();
			char[] backward = word.toCharArray();
			int size = forward.length;
			for(int idx = 0; idx < size - 1; idx++) {
				forward[idx] = backward[size - 1 - idx] = '?';
				lyrics.computeIfPresent(new String(forward), (key, value) -> value + 1);
				lyrics.computeIfPresent(new String(backward), (key, value) -> value + 1);
			}
			forward[size-1] = '?';
			lyrics.computeIfPresent(new String(forward), (key, value) -> value + 1);
		}
		
		for(int idx = 0; idx < answer.length; idx++) 
			answer[idx] = lyrics.get(queries[idx]);
		
		return answer;
	}
}
