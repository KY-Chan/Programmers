package programmers.level2.c84512;
//INDEX 'A' : 1~781, 'E' : 782 ~ 1562, 'I' : 1563 ~ ...
//INDEX 'AA' : 2 ~ 157, 'AE' : 158 ~ 313, ...
public class Solution {
	public int solution(String word) {
		int answer = 0;
		int data = 781; // (((5 + 1) * 5 + 1) * 5 + 1) * 5 + 1 = 781
		char[] chrs = word.toCharArray();
		for (int i = 0; i < chrs.length; i++) {
			answer += 1 + data * index(chrs[i]);
			data = (data - 1) / 5; 
		}
		return answer;
	}

	public int index(char c) {
		switch (c) {
		case 'A':
			return 0;
		case 'E':
			return 1;
		case 'I':
			return 2;
		case 'O':
			return 3;
		case 'U':
			return 4;
		}
		return -1;
	}
}
