package programmers.level3.c12904;
// 가장 긴팰린드롬
public class Solution {
	public int solution(String s) {
		int answer = 1;
		for (int pos = 1; pos < s.length() - 1; pos++) {
			int distance1 = Math.min(pos, s.length() - pos - 1);
			int length1 = 1;
			for (int d = 1; d <= distance1; d++) {
				if (s.charAt(pos - d) == s.charAt(pos + d))
					length1 += 2;
				else
					break;
			}

			int length2 = 0;
			int distance2 = Math.min(pos, s.length() - pos);
			for (int d = 0; d < distance2; d++) {
				if (s.charAt(pos - d - 1) == s.charAt(pos + d))
					length2 += 2;
				else
					break;
			}
			answer = Math.max(Math.max(length1, length2), answer);
		}
		return answer;
	}
}
