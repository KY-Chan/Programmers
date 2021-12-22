package programmers.level2.c60058;
// °ıÈ£ º¯È¯
public class Solution {
	public String solution(String p) {
		if (p.length() == 0) {
			return "";
		}
		String answer = "";
		int score = 0;
		boolean correctness = true;
		int idx = 0;
		int max = p.length();
		while (true) { // ±ÕÇüÀâÈù ¹®ÀÚ¿­
			if (p.charAt(idx) == '(') {
				score++;
			} else {
				score--;
				if (score < 0) {
					correctness = false;
				}
			}
			if (score == 0) {
				break;
			}
			idx++;
		}
		String v = p.substring(idx + 1);

		if (correctness) {
			String u = p.substring(0, idx + 1);
			return u + solution(v);
		} else {
			String u = p.substring(1, idx);
			u = u.replace('(', '@').replace(')', '(').replace('@', ')');
			return "(" + solution(v) + ")" + u;
		}
	}
}
