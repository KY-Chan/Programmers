package test2_2;

public class Solution {
	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		int[][] puzzle = new int[rows][columns];
		int idx = 1;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < columns; col++) {
				puzzle[row][col] = idx++;
			}
		}

		for (int stage = 0; stage < queries.length; stage++) {
			int x1 = queries[stage][0] - 1;
			int y1 = queries[stage][1] - 1;
			int x2 = queries[stage][2] - 1;
			int y2 = queries[stage][3] - 1;
			int temp = puzzle[x1][y2];
			int min = temp;
			for (int pos = y2; pos > y1; pos--) {
				min = Math.min(min, puzzle[x1][pos]);
				puzzle[x1][pos] = puzzle[x1][pos - 1];
			}
			for (int pos = x1; pos < x2; pos++) {
				min = Math.min(min, puzzle[pos][y1]);
				puzzle[pos][y1] = puzzle[pos + 1][y1];
			}
			for (int pos = y1; pos < y2; pos++) {
				min = Math.min(min, puzzle[x2][pos]);
				puzzle[x2][pos] = puzzle[x2][pos + 1];
			}
			for (int pos = x2; pos > x1; pos--) {
				min = Math.min(min, puzzle[pos][y2]);
				puzzle[pos][y2] = puzzle[pos - 1][y2];
			}
			puzzle[x1 + 1][y2] = temp;
			answer[stage] = min;
		}
		return answer;
	}
}
