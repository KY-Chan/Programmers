package programmers.level2.c17677;

import java.util.HashMap;
import java.util.Map;
// 뉴스 클러스터링
public class Solution {
	public int solution(String str1, String str2) {
		int answer = 0;
		Map<String, Integer> group1 = makeGroup(str1);
		Map<String, Integer> group2 = makeGroup(str2);
		if (group1.size() == 0 && group2.size() == 0) {
			return 65536;
		}
		Map<String, Integer> sumsetMap = new HashMap<String, Integer>(group1);
		Map<String, Integer> intersectionMap = new HashMap<String, Integer>();

		for (String key : group2.keySet()) {
			int g2 = group2.get(key);
			sumsetMap.merge(key, g2, (oldV, newV) -> oldV > newV ? oldV : newV); // sumset에는 더 큰 값을
			int g1 = group1.getOrDefault(key, 0);
			if (g1 > 0) {
				intersectionMap.put(key, g1 < g2 ? g1 : g2); // intersection에는 더 작은 값을
			}
		}
		
		int sumset = 0;
		int intersection = 0;
		
		for(int s : sumsetMap.values()) {
			sumset += s;
		}
		for(int i : intersectionMap.values()) {
			intersection += i;
		}
		
		double jaccard = (double)intersection / sumset;
		answer = (int) (65536 * jaccard);
		return answer;
	}

	public Map<String, Integer> makeGroup(String str) {
		Map<String, Integer> group = new HashMap<String, Integer>();
		for (int idx = 0; idx < str.length() - 1; idx++) {
			char[] cs = { str.charAt(idx), str.charAt(idx + 1) };
			if (cs[0] >= 97) {
				cs[0] -= 32;
			}
			if (cs[1] >= 97) {
				cs[1] -= 32;
			}
			if (cs[0] >= 65 && cs[0] <= 90) {
				if (cs[1] >= 65 && cs[1] <= 90) {
					group.merge(new String(cs), 1, (oldV, newV) -> oldV + newV);
				}
			}
		}
		return group;
	}
}
