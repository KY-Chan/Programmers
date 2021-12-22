package programmers.level1.c72410;

// 신규 아이디 추천
public class Solution {
	public String solution(String new_id) {
		String answer = "";
		// stage 1 ~ 4
		for (int idx = 0; idx < new_id.length(); idx++) {
			if (answer.length() == 15) {
				break;
			}
			char chr = new_id.charAt(idx);
			if (chr == '.') {
				if (idx != 0 && idx != new_id.length() - 1) {
					if (answer.length() > 0) {
						if (answer.charAt(answer.length() - 1) != '.') {
							answer += chr;
						}
					}
				}
			} else if (chr == '-' || chr == '.' || chr == '_') {
				answer += chr;
			} else if (chr >= 48 && chr <= 57) {
				answer += chr;
			} else if (chr >= 65 && chr <= 90) {
				chr += 32;
				answer += chr;
			} else if (chr >= 97 && chr <= 122) {
				answer += chr;
			}
		}
		if (answer.length() == 0) {
			answer = "a";
		}
		if(answer.charAt(answer.length() - 1) == '.') {
			answer = answer.substring(0, answer.length() - 1);
		}
		if (answer.length() == 1) {
			answer += answer + answer;
		}
		if (answer.length() == 2) {
			answer += answer.charAt(1);
		}
		return answer;
	}
}
