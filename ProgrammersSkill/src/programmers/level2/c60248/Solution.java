package programmers.level2.c60248;

public class Solution {
	public long solution(int w, int h) {
		long answer = 1;
		int gcd = gcd(w, h);
		answer = (long) w * h - gcd * (w / gcd + h / gcd - 1);
		return answer;
	}

	public int gcd(int a, int b) {
		while (b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}
}
