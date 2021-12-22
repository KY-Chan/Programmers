package programmers.level2.c49994;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public int solution(String dirs) {
		int answer = 0;
		// �� ��ǥ���� ��, ������ ������ ��ΰ� �湮�Ǿ����� ���θ� ����
		Set<Integer> visited = new HashSet<Integer>();
		int[] robot = { 5, 5 };
		for (char dir : dirs.toCharArray()) {
			int hash = exectueAndGetHash(robot, dir);
			if (hash != -1)
				if (visited.add(hash))
					answer++;
		}
		return answer;
	}

	// ��� ���� �� �ؽ��ڵ� ��ȯ
	public int exectueAndGetHash(int[] robot, char dir) {
		switch (dir) {
		case 'D': // "100000000" : vertical, "0101 0001" : [5,1]
			if (robot[1] > 0)
				return 256 + (robot[0] << 4) + --robot[1];
			else
				break;
		case 'L': // "000000000" : horizontal, "0101 0001" : [5,1]
			if (robot[0] > 0)
				return (--robot[0] << 4) + robot[1];
			else
				break;
		case 'R':
			if (robot[0] < 10)
				return (robot[0]++ << 4) + robot[1];
			else
				break;
		case 'U':
			if (robot[1] < 10)
				return 256 + (robot[0] << 4) + robot[1]++;
			else
				break;
		}
		return -1;
	}
}
