package programmers.level2.c12899;

public class Solution {
	public String solution(int n) {
		String answer = "";
		int num = n;
		while (num > 0) {
			num -= 1;
			if (num % 3 == 0) {
				answer = "1" + answer;
			} else if (num % 3 == 1) {
				answer = "2" + answer;
			} else if (num % 3 == 2) {
				answer = "4" + answer;
			}
			num /= 3;
		}
		return answer;
	}
}
