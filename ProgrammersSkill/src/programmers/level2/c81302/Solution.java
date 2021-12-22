package programmers.level2.c81302;

// 거리두기 확인하기
public class Solution {
	public int[] solution(String[][] places) {
		int[] answer = new int[5];
		for (int room = 0; room < 5; room++) {
			answer[room] = checkRoom(room, places);
		}
		return answer;
	}

	public int checkRoom(int room, String[][] places) {
		int[][] scores = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				char pos = places[room][i].charAt(j);
				if (pos == 'P') {
					scores[i][j] += 1;
					if (i > 0) {
						scores[i - 1][j] += 1;
					}
					if (i < 4) {
						scores[i + 1][j] += 1;
					}
					if (j > 0) {
						scores[i][j - 1] += 1;
					}
					if (j < 4) {
						scores[i][j + 1] += 1;
					}
				} else if (pos == 'X') {
					scores[i][j] += -100;
				}
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (scores[i][j] > 1) {
					return 0;
				}
			}
		}
		return 1;
	}
}
