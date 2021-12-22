package programmers.level3.c67259;

import java.util.PriorityQueue;
import java.util.Queue;

// 경주로 건설
public class Solution {
	int[][] visited;
	int width;
	Queue<Integer> prices;

	public int solution(int[][] board) {
		visited = board.clone();
		width = board.length;
		prices = new PriorityQueue<Integer>();
		prices.add(100000000);
		int answer = 0;
		dfs(0, 0, 4, -500);
		answer = prices.peek();
		System.out.println(prices);
		return answer;
	}

	public void dfs(int m, int n, int direction, int price) {
		if (price > prices.peek()) {
			visited[m][n] = price;
			return;
		}
		if (m == width - 1 && n == width - 1) { // 끝에 도달
			prices.add(price);
		} else {
			visited[m][n] = price;
			if (n < width - 1) { // RIGHT
				int nextPrice = visited[m][n + 1];
				if (nextPrice != 1) {
					int tempPrice = price + (direction == 1 ? 100 : 600);
					if(tempPrice <= nextPrice || nextPrice == 0) {
						dfs(m, n + 1, 1, tempPrice);
					}
				}
			}
			if (m < width - 1) { // DOWN
				int nextPrice = visited[m + 1][n];
				if (nextPrice != 1) {
					int tempPrice = price + (direction == 2 ? 100 : 600);
					if(tempPrice <= nextPrice || nextPrice == 0) {
						dfs(m + 1, n, 2, tempPrice);
					}
				}
			}
			if (m > 0) { // UP
				int nextPrice = visited[m - 1][n];
				if (nextPrice != 1) {
					int tempPrice = price + (direction == 0 ? 100 : 600);
					if(tempPrice <= nextPrice || nextPrice == 0) {
						dfs(m - 1, n, 0, tempPrice);
					}
				}
			}
			if (n > 0) { // LEFT
				int nextPrice = visited[m][n - 1];
				if (nextPrice != 1) {
					int tempPrice = price + (direction == 3 ? 100 : 600);
					if(tempPrice <= nextPrice || nextPrice == 0) {
						dfs(m, n - 1, 3, tempPrice);
					}
				}
			}
		}
	}
}
