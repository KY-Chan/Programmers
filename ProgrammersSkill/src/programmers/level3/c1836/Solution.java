package programmers.level3.c1836;

import java.util.ArrayList;
import java.util.List;
// 리틀 프렌즈 사천성
public class Solution {
	public String solution(int m, int n, String[] board) {
		String answer = "";
		char[][] newBoard = new char[m][n];
		for(int c = 0; c < m; c++) {
			newBoard[c] = board[c].toCharArray();
		}
		// 각 카드의 좌표가 담긴 리스트 구하기
		List<int[]> locList = toList(m, n, newBoard);
		while (true) {
			int idx = -1;
			while(++idx < locList.size()) {
				if(removeCard(locList.get(idx), newBoard)) {
					answer += (char)(locList.get(idx)[0]);
					locList.remove(idx);
					idx = 0;
					break;
				}
			}
			if(idx == locList.size()) {
				if(locList.size() != 0) {
					answer = "IMPOSSIBLE";
				}
				break;
			}
		}
		return answer;
	}

	// 각 카드의 좌표가 담긴 리스트 구하기
	public List<int[]> toList(int m, int n, char[][] board) {
		// A to Z {{존재여부,x1좌표,y1좌표,x2좌표,y2좌표}, {...}, ...}
		int[][] location = new int[26][5];
		// A to Z 위치 기록
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				char card = board[i][j];
				if (card >= 'A' && card <= 'Z') {
					int[] temp = location[card - 65];
					if (temp[0] == 0) {
						temp[0] = card;
						temp[1] = i;
						temp[2] = j;
					} else {
						temp[3] = i;
						temp[4] = j;
					}
				}
			}
		}
		// List에 담기
		List<int[]> locList = new ArrayList<int[]>();
		for (int i = 0; i < 26; i++) {
			if (location[i][0] > 0) {
				locList.add(location[i]);
			}
		}
		return locList;
	}

	public boolean removeCard(int[] list, char[][] board) {
		boolean removable = true;
		int[] start = { list[1], list[2] };
		int[] end = { list[3], list[4] };
		// 경유지 1
		if(start[1] <= end[1]) {
			for (int x = start[1] + 1; x <= end[1]; x++) {
				char check = board[start[0]][x];
				if (check != '.') {
					if(check != list[0]) {
						removable = false;
						break;
					}
				}
			}
		} else {
			for (int x = end[1] + 1; x <= start[1]; x++) {
				char check = board[end[0]][x];
				if (check != '.') {
					if(check != list[0]) {
						removable = false;
						break;
					}
				}
			}
		}
		if (removable) {
			for (int y = start[0] + 1; y < end[0]; y++) {
				if (board[y][end[1]] != '.') {
					removable = false;
					break;
				}
			}
		}
		// 경유지 2 (경유지 1이 성공하면 검사 결과 불필요)
		if(!removable) {
			for (int y = start[0] + 1; y < end[0]; y++) {
				if (board[y][start[1]] != '.') {
					return false;
				}
			}

			if(start[1] <= end[1]) {
				for (int x = start[1]; x < end[1]; x++) {
					char check = board[end[0]][x];
					if (check != '.') {
						if(check != list[0]) {
							return false;
						}
					}
				}
			} else {
				for (int x = end[1]; x < start[1]; x++) {
					char check = board[start[0]][x];
					if (check != '.') {
						if(check != list[0]) {
							return false;
						}
					}
				}
			}
		}
		
		
		board[start[0]][start[1]] = '.';
		board[end[0]][end[1]] = '.';
		
		return true;
	}
}
