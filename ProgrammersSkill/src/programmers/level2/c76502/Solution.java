package programmers.level2.c76502;
// 괄호 회전하기
public class Solution {
	public int solution(String s) {
		int answer = 0;
		// 홀수개면 0 반환
		if (s.length() % 2 > 0)
			return answer;
		// s가 변경되었는지 확인하기 위한 비교용
		String s2 = "";
		while (!s.equals(s2)) {
			s2 = s;
			// "), ], }", "(, [, {" 순서로 나온 경우에 회전시켜줌
			for (int i = 0; i < s.length() - 1; i++) {
				char c1 = s.charAt(i);
				if (c1 == ')' || c1 == ']' || c1 == '}') {
					char c2 = s.charAt(i + 1);
					if (c2 == '(' || c2 == '[' || c2 == '{') {
						s = s.substring(i + 1) + s.substring(0, i + 1);
						break;
					}
				}
			}
			// 가능하면 가장 큰 올바른 괄호 문자열을 A로 치환
			s = s.replaceAll("\\(A*\\)", "A")
				 .replaceAll("\\[A*\\]", "A")
				 .replaceAll("\\{A*\\}", "A");
		}
		// 올바른 문자열이 아닐 경우 0 반환
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) != 'A')
				return answer;
		// 결국 가장 큰 단위의 A의 개수가 정답이 된다
		answer = s.length();
		return answer;
	}
}
