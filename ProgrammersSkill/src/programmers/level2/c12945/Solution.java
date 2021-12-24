package programmers.level2.c12945;

public class Solution {
	public int solution(int n) {
		int answer = 0;
		int a = 1;
		int b = 1;
		boolean flag = false;
		for (int i = 1; i < n; i++) {
			if (flag = !flag)
				a = (a + b) % 1234567;
			else
				b = (a + b) % 1234567;
		}
		if (flag)
			return b;
		else
			return a;
	}
}
