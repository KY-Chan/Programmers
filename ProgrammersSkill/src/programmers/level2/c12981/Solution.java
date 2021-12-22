package programmers.level2.c12981;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> history = new HashSet<String>();
        for(int idx = 0; idx < words.length; idx++) {
        	if(idx > 0) {
        		if(words[idx - 1].charAt(words[idx-1].length() - 1) != words[idx].charAt(0)) {
        			int[] answer = {idx % n + 1, idx / n + 1};
            		return answer;
        		}
        	}
        	if(history.contains(words[idx])) {
                int[] answer = {idx % n + 1, idx / n + 1};
        		return answer;
        	} else {
        		history.add(words[idx]);
        	}
        }
        int[] answer = {0, 0};
        return answer;
    }
}
