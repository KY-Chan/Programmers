package programmers.level2.c42883;
// 큰 수 만들기
public class Solution {
	public String solution(String number, int k) {
		StringBuilder ans = new StringBuilder(number);
		int start = 0;
		char max = ans.charAt(0);
		for (int stage = 0; stage < k; stage++) {
			boolean pop = false;
			for (int i = start; i < ans.length() - 1; i++) {
				char c1 = ans.charAt(i);
				char c2 = ans.charAt(i + 1);
				if (c1 < c2) {
					if (max < c2)
						max = c2;
					ans.deleteCharAt(i);
					pop = true;
					if(i == start)
						start = start == 0 ? 0 : start - 1;
					break;
				} else if (c1 == c2) {
					start = i;
				}
			}
			if (!pop) {
				ans.delete(ans.length() - k + stage, ans.length());
				break;
			}
		}
		return ans.toString();
	}
}
