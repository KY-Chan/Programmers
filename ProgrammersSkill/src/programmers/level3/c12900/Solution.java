package programmers.level3.c12900;

public class Solution {
	public int solution(int n) {
		int answer = 0;
		long[] fibo = {1, 2, 0};
		if(n < 3) {
			answer = n;
		} else {
			for(int idx = 2; idx < n; idx++) {
				fibo[idx % 3] = (fibo[(idx - 2) % 3] + fibo[(idx - 1) % 3]) % 1000000007;
			}
			answer = (int) fibo[(n - 1) % 3];
		}
		return answer;
	}
}
