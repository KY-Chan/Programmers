package programmers.level2.c60057;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public int solution(String s) {
		int answer = s.length();
		for (int stage = 1; stage <= s.length() / 2; stage++) {
			int size = s.length();
			List<String> strs = new ArrayList<String>();
			int idx = 0;
			while (idx < s.length()) {
				strs.add(s.substring(idx, Math.min(idx + stage, s.length())));
				idx += stage;
			}
			idx = 0;
			int dupple = 1;
			while (idx < strs.size() - 1) {
				if (strs.get(idx).equals(strs.get(idx + 1))) {
					dupple++;
					size -= stage;
				} else {
					if(dupple > 1) {
						size += (int)(Math.log10(dupple) + 1);
						dupple = 1;
					}
				}
				idx++;
			}
			if(dupple > 1) {
				size += (int)(Math.log10(dupple) + 1);
				dupple = 1;
			}
			answer = Math.min(answer, size);
		}
		return answer;
	}
}
