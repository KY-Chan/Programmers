package programmers.level2.c76502;
// ��ȣ ȸ���ϱ�
public class Solution {
	public int solution(String s) {
		int answer = 0;
		// Ȧ������ 0 ��ȯ
		if (s.length() % 2 > 0)
			return answer;
		// s�� ����Ǿ����� Ȯ���ϱ� ���� �񱳿�
		String s2 = "";
		while (!s.equals(s2)) {
			s2 = s;
			// "), ], }", "(, [, {" ������ ���� ��쿡 ȸ��������
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
			// �����ϸ� ���� ū �ùٸ� ��ȣ ���ڿ��� A�� ġȯ
			s = s.replaceAll("\\(A*\\)", "A")
				 .replaceAll("\\[A*\\]", "A")
				 .replaceAll("\\{A*\\}", "A");
		}
		// �ùٸ� ���ڿ��� �ƴ� ��� 0 ��ȯ
		for (int i = 0; i < s.length(); i++)
			if (s.charAt(i) != 'A')
				return answer;
		// �ᱹ ���� ū ������ A�� ������ ������ �ȴ�
		answer = s.length();
		return answer;
	}
}
