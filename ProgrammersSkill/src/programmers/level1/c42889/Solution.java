package programmers.level1.c42889;

import java.util.Arrays;

public class Solution {
	public int[] solution(int N, int[] stages) {
		// {stage��ȣ, ������, ������}
		int players = stages.length;
		int[][] stageInfo = new int[N][3];
		for (int i = 0; i < N; i++) {
			stageInfo[i][0] = i + 1;
			stageInfo[i][2] = players;
		}
		// �� stage�� ������ ���
		for (int stage : stages)
			if (stage <= N)
				stageInfo[stage - 1][1]++;
		// �� stage�� ������ ���
		for (int i = 1; i < N; i++)
			stageInfo[i][2] = stageInfo[i - 1][2] - stageInfo[i - 1][1];
		// �������� ���� ��, �������� ��ȣ ���� ������ ����
		Arrays.sort(stageInfo, (o1, o2) -> {
			double f1 = o1[2] == 0 ? 0 : (double) o1[1]/ o1[2];
			double f2 = o2[2] == 0 ? 0 : (double) o2[1] / o2[2];
			if(f2 < f1)
				return -1;
			else if (f2 > f1)
				return 1;
			else
				return o1[0] - o2[0];
		});
		// answer �迭�� ���
		int[] answer = new int[N];
		for (int i = 0; i < N; i++)
			answer[i] = stageInfo[i][0];

		return answer;
	}
}
