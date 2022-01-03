package programmers.level3.c12952;

public class Solution {
	int way = 0;

	public int solution(int n) {
		int[][] board = new int[n][n];
		nQueen(board, 0, n);

		int answer = way;
		return answer;
	}

	public int[][] copyArray(int[][] origin) {
		int[][] copy = new int[origin.length][origin[0].length];
		for (int i = 0; i < origin.length; i++)
			for (int j = 0; j < origin[0].length; j++)
				copy[i][j] = origin[i][j];
		return copy;
	}

	public void nQueen(int[][] board, int d, int n) {
		if (d == n) {
			way++;
			return;
		}
		// 가로 n회
		for (int i = 0; i < n; i++) {
			// 배치가능
			if(board[d][i] == 0) {
				int[][] copy = copyArray(board);
				// 가로열 모두 배치불가
				for(int j = 0; j < n; j++) 
					for(int k = 0; k < n; k++) 
						if(i == k || j == d || k == i - j  + d|| k == i + j - d)
							copy[j][k] = 1;
				nQueen(copy, d + 1, n);
			}
			
		}
	}
}
