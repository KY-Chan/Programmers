package programmers.level2.c12949;

public class Solution {
	public int[][] solution(int[][] arr1, int[][] arr2) {
		int col1 = arr1.length;
		int row1 = arr1[0].length;
		int col2 = arr2.length;
		int row2 = arr2[0].length;
		int[][] answer = new int[col1][row2];

		for (int i = 0; i < col1; i++) {
			for (int j = 0; j < row2; j++) {
				int value = 0;
				for(int k = 0; k < row1; k++)
					value += arr1[i][k] * arr2[k][j];
				answer[i][j] = value;
			}
		}
		return answer;
	}
}
