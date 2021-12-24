package programmers.level2.c12905;

public class Solution {
	public int solution(int[][] board) {
		int height = board.length;
		int width = board[0].length;
		int answer = 0;
		// 왼쪽과 위 테두리부터 검사
		for (int y = 0; y < height; y++)
			if (board[y][0] == 1)
				answer = 1;
		for (int x = 0; x < width; x++)
			if (board[0][x] == 1)
				answer = 1;
		// 검사 시작
		for (int y = 1; y < height; y++) {
			for (int x = 1; x < width; x++) {
				if (board[y][x] == 1) {
					int min = Math.min(board[y-1][x-1],board[y-1][x]);
					 board[y][x] = Math.min(board[y][x-1], min) + 1;
					 answer = Math.max(board[y][x], answer);
				}
			}
		}
		return answer * answer;
	}
}
