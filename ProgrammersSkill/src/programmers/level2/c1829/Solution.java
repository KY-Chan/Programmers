package programmers.level2.c1829;

import java.util.LinkedList;
import java.util.Queue;
// īī�� ������ �÷�����
public class Solution {
	public int[] solution(int m, int n, int[][] picture) {
		int[][] myPicture = new int[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				myPicture[i][j] = picture[i][j];
			}
		}
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (myPicture[i][j] > 0) { // ���� �����Ҷ���
					int size = 0;
					numberOfArea++;
					Queue<int[]> que = new LinkedList<int[]>();
					int[] pos = { i, j };
					que.add(pos);
					int curColor = myPicture[i][j];
					if(curColor <= 0) {
						continue;
					}
					myPicture[i][j] = -1;
					while (!que.isEmpty()) {
						int[] curPos = que.poll();
						int y = curPos[0];
						int x = curPos[1];
						size++;
						myPicture[y][x] = 0;
						if (x > 0) { // ���� Ž��
							if (myPicture[y][x - 1] == curColor) {
								myPicture[y][x - 1] = 0;
								int[] nextPos = { y, x - 1 };
								que.add(nextPos);
							}
						}
						if (x < n - 1) { // ������ Ž��
							if (myPicture[y][x + 1] == curColor) {
								myPicture[y][x + 1] = 0;
								int[] nextPos = { y, x + 1 };
								que.add(nextPos);
							}
						}
						if (y > 0) { // �� Ž��
							if (myPicture[y - 1][x] == curColor) {
								myPicture[y - 1][x] = 0;
								int[] nextPos = { y - 1, x };
								que.add(nextPos);
							}
						}
						if (y < m - 1) { // �Ʒ� Ž��
							if (myPicture[y + 1][x] == curColor) {
								myPicture[y + 1][x] = 0;
								int[] nextPos = { y + 1, x };
								que.add(nextPos);
							}
						}
						
					}
					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
				}
			}
		}
		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;
		return answer;
	}
}
