package programmers.level2.c17680;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
	public int solution(int cacheSize, String[] cities) {
		int answer = 0;
		Map<String, Integer> mapCache = new LinkedHashMap<String, Integer>(cacheSize, 0.75f, true);
		for (String city : cities) {
			city = city.toLowerCase();
			if (mapCache.containsKey(city)) {
				mapCache.put(city, 0);
				answer += 1;
			} else {
				if(cacheSize != 0) {
					if(mapCache.size() == cacheSize)
						mapCache.remove(mapCache.keySet().toArray()[0]);
					mapCache.put(city, 0);
				}
				answer += 5;
			}
		} 
		return answer;
	}
}
