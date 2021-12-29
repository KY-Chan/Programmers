package programmers.level3.c87694;

public class Solution {
	public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		int answer = 0;
		boolean[][] map = new boolean[51][51];
		for (int[] rect : rectangle)
			for (int y = rect[1]; y < rect[3]; y++)
				for (int x = rect[0]; x < rect[2]; x++)
					map[y][x] = true;

		int total = 0;
		int cX = characterX;
		int cY = characterY;
		int curD = 0;
		do {
			boolean moved = false;
			if (curD == 0) {
				if (map[cY][cX - 1] ^ map[cY][cX]) {
					cY++;
					moved = true;
				}
			} else if (curD == 1) {
				if (map[cY - 1][cX] ^ map[cY][cX]) {
					cX++;
					moved = true;
				}

			} else if (curD == 2) {
				if (map[cY - 1][cX - 1] ^ map[cY - 1][cX]) {
					cY--;
					moved = true;
				}

			} else {
				if (map[cY - 1][cX - 1] ^ map[cY][cX - 1]) {
					cX--;
					moved = true;
				}
			}
			if (moved) {
				total++;
				curD = curD == 0 ? 3 : curD - 1;
				if(cX == itemX && cY == itemY)
					answer = total;
			} else
				curD = curD == 3 ? 0 : curD + 1;

		} while (total == 0 || cX != characterX || cY != characterY);
		
		if(answer > total - answer)
			answer = total - answer;
		return answer;
	}
}
