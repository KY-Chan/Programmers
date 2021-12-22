package programmers.level3.c60059;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public boolean solution(int[][] key, int[][] lock) {
		boolean answer = false;
		int M = key.length;
		int N = lock.length;

		List<ArrayList<Integer>> keyStr = keyStream(key, 1);
		List<ArrayList<Integer>> lockStr = keyStream(lock, 0);

		int keySize = keyStr.size();
		int lockSize = lockStr.size();
		int trying = keySize - lockSize;
		if(lockSize == 0 ) {
			answer = true;
			return answer;
		}
		for (int stage = 0; stage < 4; stage++) {
			if (stage != 0) {
				key = rotation(key);
				keyStr = keyStream(key, 1);
			}
			for (int pos = 0; pos <= trying; pos++) {
				int[] offset = new int[2];
				offset[0] = keyStr.get(pos).get(0) - lockStr.get(0).get(0);
				offset[1] = keyStr.get(pos).get(1) - lockStr.get(0).get(1);
				List<ArrayList<Integer>> newKeyStr = new ArrayList<ArrayList<Integer>>();
				for (ArrayList<Integer> k : keyStr) {
					ArrayList<Integer> newKey = new ArrayList<Integer>(k);
					newKey.set(0, newKey.get(0) - offset[0]);
					newKey.set(1, newKey.get(1) - offset[1]);
					if(!lockStr.contains(newKey)) {
						newKeyStr.add(newKey);
					}
				}
				if(newKeyStr.size() == trying) {
					boolean check = true;
					for (ArrayList<Integer> badKey : newKeyStr) {
						int x = badKey.get(0);
						int y = badKey.get(1);
						if(x >= 0 && x < N && y >= 0 && y < N) {
							if(lock[x][y] == 1) {
								check = false;
								break;
							}
						}
					}
					if(check) {
						answer = true;
						break;
					}
				}
			}
			if(answer) {
				break;
			}
		}

		return answer;
	}

	// ¹è¿­ È¸Àü
	public int[][] rotation(int[][] key) {
		int M = key.length;
		int[][] newKey = new int[M][M];
		for (int a = 0; a < M; a++) {
			for (int b = 0; b < M; b++) {
				newKey[a][b] = key[M - b - 1][a];
			}
		}
		return newKey;
	}

	// ¿­¼èÀÇ ÁÂÇ¥ List
	public List<ArrayList<Integer>> keyStream(int[][] key, int type) {
		int M = key.length;
		List<ArrayList<Integer>> newKeyStream = new ArrayList<ArrayList<Integer>>();
		for (int a = 0; a < M; a++) {
			for (int b = 0; b < M; b++) {
				if (key[a][b] == type) {
					ArrayList<Integer> keyLocation = new ArrayList<Integer>();
					keyLocation.add(a);
					keyLocation.add(b);
					newKeyStream.add(keyLocation);
				}
			}
		}
		return newKeyStream;
	}

}
