package programmers.level4.c60060;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
	public int[] solution(String[] words, String[] queries) {
		Map<String, Set<Integer>> lyrics = new HashMap<String, Set<Integer>>();
		// words 마다 반복
		for (int wIdx = 0; wIdx < words.length; wIdx++) {
			String word = words[wIdx];
			// query에 대응할 수 있는 키를 모두 생성하여 등록 
			// (fro?? : +5fro), (??do : -4do) 에 대응됨
			// 예를 들어 fro 는 +3f, +3fr, +3fro, -3o,
			// word의 단어마다 반복
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
			// query를 분석하여 key 생성
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
	// map에 key가 존재하지 않으면 새로 생성하여 입력
	public void putKeyValue(Map<String, Set<Integer>> lyrics, String key, int wIdx) {
		if (!lyrics.containsKey(key))
			lyrics.put(key, new HashSet<Integer>());
		lyrics.get(key).add(wIdx);
	}
}
