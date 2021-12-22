package programmers.level3.c1836;

import java.util.ArrayList;
import java.util.List;
// ��Ʋ ������ ��õ��
public class Solution {
	public String solution(int m, int n, String[] board) {
		String answer = "";
		char[][] newBoard = new char[m][n];
		for(int c = 0; c < m; c++) {
			newBoard[c] = board[c].toCharArray();
		}
		// �� ī���� ��ǥ�� ��� ����Ʈ ���ϱ�
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

	// �� ī���� ��ǥ�� ��� ����Ʈ ���ϱ�
	public List<int[]> toList(int m, int n, char[][] board) {
		// A to Z {{���翩��,x1��ǥ,y1��ǥ,x2��ǥ,y2��ǥ}, {...}, ...}
		int[][] location = new int[26][5];
		// A to Z ��ġ ���
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
		// List�� ���
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
		// ������ 1
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
		// ������ 2 (������ 1�� �����ϸ� �˻� ��� ���ʿ�)
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
