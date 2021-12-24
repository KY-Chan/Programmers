package programmers.level2.c12951;

public class Solution {
	public String solution(String s) {
		char[] cs = s.toCharArray();
		if(cs[0] >= 'a' && cs[0] <= 'z')
			cs[0] -= 32;
		for(int i = 1; i < cs.length; i++) {
			if(cs[i - 1] == ' ') {
				if(cs[i] >= 'a' && cs[i] <= 'z')
					cs[i] -= 32;
			} else if (cs[i] >= 'A' && cs[i] <= 'Z')
				cs[i] += 32;
		}
        String answer = new String(cs);
        
        return answer;
    }
}
