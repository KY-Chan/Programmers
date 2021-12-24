package programmers.level2.c12909;

public class Solution {
	boolean solution(String s) {
		int score = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				score++;
			else if (--score < 0)
				return false;
		}
		if (score == 0)
			return true;
		else
			return false;
	}
}
