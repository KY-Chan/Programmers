package programmers.level2.c42578;

import java.util.HashMap;
import java.util.Map;

// ¿ß¿Â
public class Solution {
	public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> closet = new HashMap<String, Integer>();
        for(String[] wear : clothes) {
        	closet.merge(wear[1], 1, (total, add) -> total + add);
        }
        for(String key : closet.keySet()) {
        	answer *= closet.get(key) + 1;
        }
        answer -= 1;
        return answer;
    }
}
