package programmers.level2.c87377;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
// 교점에 별 만들기
public class Solution {
	public String[] solution(int[][] line) {
		int size = line.length;
		long minX, minY, maxX, maxY;
		minX = minY = Long.MAX_VALUE;
		maxX = maxY = Long.MIN_VALUE;
		Set<List<Long>> stars = new HashSet<List<Long>>();
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				int[] l1 = line[i];
				int[] l2 = line[j];
				List<Long> star = new ArrayList<Long>();
				long temp = l1[0] * l2[1] - l1[1] * l2[0];
				if (temp != 0) {
					double x = ((double) l1[1] * l2[2] - l1[2] * l2[1]) / temp;
					if (Math.floor(x) == x) {
						double y = ((double) l1[2] * l2[0] - l1[0] * l2[2]) / temp;
						if (Math.floor(y) == y) {
							long sx = (long) Math.floor(x);
							long sy = (long) Math.floor(y);
							star.add(sx);
							star.add(sy);
							stars.add(star);
							minX = minX < sx ? minX : sx;
							maxX = maxX > sx ? maxX : sx;
							minY = minY < sy ? minY : sy;
							maxY = maxY > sy ? maxY : sy;
						}
					}
				}
			}
		}

		char[][] outputs = new char[(int) (maxY - minY + 1)][(int) (maxX - minX + 1)];
		for (int i = 0; i < maxY - minY + 1; i++)
			for (int j = 0; j < maxX - minX + 1; j++)
				outputs[i][j] = '.';

		for (List<Long> s : stars)
			outputs[(int) (s.get(1) - minY)][(int) (s.get(0) - minX)] = '*';

		String[] answer = new String[outputs.length];
		for (int i = 0; i < answer.length; i++)
			answer[i] = new String(outputs[answer.length - 1 - i]);
		return answer;
	}
}
