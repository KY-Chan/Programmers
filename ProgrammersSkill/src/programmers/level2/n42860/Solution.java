package programmers.level2.n42860;
// 조이스틱 안품.
public class Solution {
	public int solution(String name) {
		int answer = 0;
		int size = name.length();
		char[] nameArray = name.toCharArray();
		char[] myName = new char[size];
		for (int i = 0; i < size; i++) {
			myName[i] = 'A';
		}
		int cursor = 0;
		while (!equals(nameArray, myName)) {
			//int[] costArray = new int[size];
			int minV = 100;
			int minI = 0;
			for (int i = 0; i < size; i++) {
				if (myName[i] != nameArray[i]) {
					// 거리 구하기
					int dist = Math.abs(cursor - i);
					if (dist > size / 2) {
						dist = size - dist;
					}
					int move = Math.abs(myName[i] - nameArray[i]);
					if (move > 13) {
						move = 26 - move;
					}
					//costArray[i] = dist + move;
					if (dist + move < minV) {
						minV = dist + move;
						minI = i;
					}
				}
			}
			myName[minI] = nameArray[minI];
			cursor = minI;
			answer += minV;
		}
		return answer;
	}

	public boolean equals(char[] c1, char[] c2) {
		for (int i = 0; i < c1.length; i++) {
			if (c1[i] != c2[i]) {
				return false;
			}
		}
		return true;
	}
}
