package programmers.level3.c84021;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	public int solution(int[][] game_board, int[][] table) {
		int answer = 0;
		List<int[][]> emptyBlock = getBlock(game_board, 0);
		List<int[][]> matchBlock = getBlock(table, 1);
		// �� ������ ���� ȸ�����Ѱ��鼭 
		for (int[][] match : matchBlock) {
			for (int i = 0; i < emptyBlock.size(); i++) {
				int size = isFitAndReturnSize(match, emptyBlock.get(i));
				if(size > 0) {
					emptyBlock.remove(i);
					answer += size;
					break;
				}
			}
		}
		return answer;
	}
	// �� 2�����迭 ����
	public List<int[][]> getBlock(int[][] arr, int type) {
		List<int[][]> blocks = new ArrayList<int[][]>();
		boolean[][] visited = new boolean[arr.length][arr.length];
		int[][] dirt = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		// �迭 Ž��
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				// ��ȿ�� ���� ã�Ƴ��� BFS
				if (arr[i][j] == type && !visited[i][j]) {
					List<int[]> block = new ArrayList<int[]>();
					Queue<int[]> que = new LinkedList<int[]>();
					int[] first = { i, j };
					block.add(first);
					que.add(first);
					visited[i][j] = true;
					while (!que.isEmpty()) {
						int[] cur = que.poll();
						// �����¿� Ž��
						for (int[] d : dirt) {
							int[] next = { cur[0] + d[0], cur[1] + d[1] };
							if (next[0] >= 0 && next[0] < arr.length) {
								if (next[1] >= 0 && next[1] < arr.length) {
									if (arr[next[0]][next[1]] == type && !visited[next[0]][next[1]]) {
										visited[next[0]][next[1]] = true;
										block.add(next);
										que.add(next);
									}
								}
							}
						}
					}
					// �� ����� ��ȯ(�� ũ�⸦ ������ ����)
					block.sort((o1, o2) -> o1[0] - o2[0]);
					int minY = block.get(0)[0];
					int maxY = block.get(block.size() - 1)[0];
					block.sort((o1, o2) -> o1[1] - o2[1]);
					int minX = block.get(0)[1];
					int maxX = block.get(block.size() - 1)[1];
					int[][] blockArray = new int[maxY - minY + 1][maxX - minX + 1];
					for (int[] b : block)
						blockArray[b[0] - minY][b[1] - minX] = block.size();
					blocks.add(blockArray);
				}
			}
		}

		return blocks;
	}
	// 2�����迭 ȸ��
	public int[][] rotateArray(int[][] arr) {
		int[][] result = new int[arr[0].length][arr.length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				result[i][j] = arr[result[0].length - j - 1][i];
			}
		}
		return result;
	}

	public int isFitAndReturnSize(int[][] arr1, int[][] arr2) {
		// ��� ũ�Ⱑ �ٸ��� 0 ����
		int s1 = 0;
		int s2 = 0;
		for (int a1 : arr1[0])
			if (a1 > 0) {
				s1 = a1;
				break;
			}
		for (int a2 : arr2[0])
			if (a2 > 0) {
				s2 = a2;
				break;
			}
		if(s1 != s2)
			return 0;
		// arr2�� ȸ�����Ѱ��� ��ġ���� Ȯ��
		for (int r = 0; r < 4; r++) {
			if (r > 0)
				arr2 = rotateArray(arr2);
			if (arr1.length != arr2.length)
				continue;
			if (arr1[0].length != arr2[0].length)
				continue;
			boolean flag = true;
			for (int i = 0; i < arr1.length; i++) 
				if (flag) 
					for (int j = 0; j < arr1[0].length; j++) 
						if (flag) 
							if (arr1[i][j] != arr2[i][j])
								flag = false;
					
			if(flag)
				return s1;
		}

		return 0;
	}
}
