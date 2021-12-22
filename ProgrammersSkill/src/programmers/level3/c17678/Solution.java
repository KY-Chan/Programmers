package programmers.level3.c17678;

import java.util.PriorityQueue;
import java.util.Stack;
// ��Ʋ����
public class Solution {
	public String solution(int n, int t, int m, String[] timetable) {
		String answer = "";
		PriorityQueue<Integer> crew = new PriorityQueue<Integer>();
		// timetable �� ������
		for (String time : timetable) {
			String[] str = time.split(":");
			int nextCrew = Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
			crew.add(nextCrew);
		}

		// shuttle �� ������.
		int[] shuttle = new int[n];
		for (int i = 0; i < n; i++) {
			shuttle[i] = 540 + t * i;
		}
		
		// ������ ũ�� �¿��
		int lastTime = 540;
		Stack<Integer> lastShuttle = new Stack<Integer>();
		// ��Ʋ ���� ��� N
		for (int N = 0; N < n; N++) {
			// ���� ���� M
			for (int M = 0; M < m; M++) {
				if (!crew.isEmpty()) {
					int front = crew.peek();
					if (front <= shuttle[N]) {
						crew.poll();
						// ���� ž���ο� ���
						if (N == n - 1) {
							lastShuttle.add(front);
						}
					}
				}
			}
			if (N < n - 1) {
				lastTime += t;
			}
		}
		int con = 0;
		if(lastShuttle.size() != m) {
			// �ڸ��� ������ ���� �ð��� ���߸� ��
			con = lastTime;
		} else {
			con = lastShuttle.peek() - 1;
		}
		
		
		answer = String.format("%02d:%02d", con / 60, con % 60);
		return answer;
	}
}
