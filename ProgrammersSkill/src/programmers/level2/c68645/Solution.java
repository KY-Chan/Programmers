package programmers.level2.c68645;

public class Solution {
	public int[] solution(int n) {
		int[][] arrays = new int[n][n];
		int number = 1;
		for(int stage = 0; stage <= n / 2; stage++) {
			for(int pos = 2 * stage; pos < n - stage ; pos++) {
				arrays[pos][stage] = number++;
			}
			for(int pos = stage + 1; pos < n - 2 * stage - 1; pos++) {
				arrays[n - stage - 1][pos] = number++;
			}
			for(int pos = n - 2 * stage - 1; pos > stage; pos--) {
				arrays[pos + stage][pos] = number++;
			}
		}
		int[] answer = new int[n * (n+1) / 2];
		int idx = 0;
		for(int y = 0; y < n; y++) {
			for(int x = 0; x <= y; x++) {
				answer[idx++] = arrays[y][x];
			}
		}
		return answer;
	}
}
