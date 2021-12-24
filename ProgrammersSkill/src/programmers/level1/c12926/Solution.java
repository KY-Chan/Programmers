package programmers.level1.c12926;

public class Solution {
	public String solution(String s, int n) {
		char[] cs = s.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (cs[i] >= 'a' && cs[i] <= 'z') {
				cs[i] += n;
				if(cs[i] > 'z')
					cs[i] -= 26;
			} else if (cs[i] >= 'A' && cs[i] <= 'Z') {
				cs[i] += n;
				if(cs[i] > 'Z')
					cs[i] -= 26;
			}
		}
		String answer = new String(cs);
		return answer;
	}
}
