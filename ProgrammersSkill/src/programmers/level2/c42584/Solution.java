package programmers.level2.c42584;

// 주식 가격
public class Solution {
	public int[] solution(int[] prices) {
		int size = prices.length;
		int[] answer = new int[size];

		int count = 0;
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				answer[i]++;
				if(prices[i] > prices[j])
					break;
			}
		}
		return answer;
	}
}
