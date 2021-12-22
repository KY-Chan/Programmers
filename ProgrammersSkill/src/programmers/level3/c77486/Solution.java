package programmers.level3.c77486;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		int[] answer = new int[enroll.length];
		// ¿Ã∏ß ¿Œµ¶ΩÃ
		Map<String, Integer> index = new HashMap<String, Integer>();
		for (int idx = 0; idx < enroll.length; idx++) {
			index.put(enroll[idx], idx);
		}
		// ∞ËªÍ
		for (int idx = 0; idx < seller.length; idx++) {
			int mine = amount[idx] * 100;
			String person = seller[idx];
			while(!person.equals("-") && mine > 0) {
				int yours = mine / 10;
				answer[index.get(person)] += mine - yours;
				mine = yours;
				person = referral[index.get(person)];
			}
		}
		return answer;
	}
}
