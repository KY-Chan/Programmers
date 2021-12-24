package programmers.level4.c60060;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
	public int[] solution(String[] words, String[] queries) {
		Map<String, Set<Integer>> lyrics = new HashMap<String, Set<Integer>>();
		// words ���� �ݺ�
		for (int wIdx = 0; wIdx < words.length; wIdx++) {
			String word = words[wIdx];
			// query�� ������ �� �ִ� Ű�� ��� �����Ͽ� ��� 
			// (fro?? : +5fro), (??do : -4do) �� ������
			// ���� ��� fro �� +3f, +3fr, +3fro, -3o,
			// word�� �ܾ�� �ݺ�
			String genKey = "+" + word.length();
			putKeyValue(lyrics, genKey, wIdx);
			for (int sIdx = 0; sIdx < word.length(); sIdx++) {
				genKey += word.charAt(sIdx);
				putKeyValue(lyrics, genKey, wIdx);
				String genKey2 = "-" + word.length() + word.substring(sIdx);
				putKeyValue(lyrics, genKey2, wIdx);
			}

		}
		
		int[] answer = new int[queries.length];
		for (int qIdx = 0; qIdx < queries.length; qIdx++) {
			String query = queries[qIdx];
			// query�� �м��Ͽ� key ����
			String key = "";
			if (query.charAt(query.length() - 1) == '?')
				key = "+";
			else
				key = "-";
			key += query.length() + query.replace("?", "");
			
			answer[qIdx] = lyrics.getOrDefault(key, new HashSet<Integer>()).size();
		}

		return answer;
	}
	// map�� key�� �������� ������ ���� �����Ͽ� �Է�
	public void putKeyValue(Map<String, Set<Integer>> lyrics, String key, int wIdx) {
		if (!lyrics.containsKey(key))
			lyrics.put(key, new HashSet<Integer>());
		lyrics.get(key).add(wIdx);
	}
}
