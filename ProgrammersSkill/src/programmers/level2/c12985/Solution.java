package programmers.level2.c12985;

public class Solution {
	public int solution(int n, int a, int b) {
		int answer = 0;
		int num = 1;
		while (answer < 21) {
			answer++;
			num *= 2;
			int A = (a - 1) / num;
			int B = (b - 1) / num;
			if(A == B) {
				break;
			}
		}
		return answer;
	}
}
