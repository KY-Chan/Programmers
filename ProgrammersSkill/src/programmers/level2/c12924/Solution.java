package programmers.level2.c12924;

// 숫자의 표현
public class Solution {
	public int solution(int n) {
		int answer = 1;
		int half = n % 2 == 0 ? n / 2 : n / 2 + 1;
		int[] numbers = new int[half];
		for (int i = 0; i < half; i++)
			numbers[i] = i + 1;
		for (int i = 0; i < half; i++) {
			int sum = 0;
			for (int j = i; j < half; j++) {
				sum += numbers[j];
				if (sum >= n)
					break;
			}
			if (sum == n)
				answer++;
		}
		return answer;
	}
}
