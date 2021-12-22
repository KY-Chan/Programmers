package programmers.level3.c17678;

import java.util.PriorityQueue;
import java.util.Stack;
// 셔틀버스
public class Solution {
	public String solution(int n, int t, int m, String[] timetable) {
		String answer = "";
		PriorityQueue<Integer> crew = new PriorityQueue<Integer>();
		// timetable 분 단위로
		for (String time : timetable) {
			String[] str = time.split(":");
			int nextCrew = Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
			crew.add(nextCrew);
		}

		// shuttle 분 단위로.
		int[] shuttle = new int[n];
		for (int i = 0; i < n; i++) {
			shuttle[i] = 540 + t * i;
		}
		
		// 버스에 크루 태우기
		int lastTime = 540;
		Stack<Integer> lastShuttle = new Stack<Integer>();
		// 셔틀 버스 대수 N
		for (int N = 0; N < n; N++) {
			// 버스 정원 M
			for (int M = 0; M < m; M++) {
				if (!crew.isEmpty()) {
					int front = crew.peek();
					if (front <= shuttle[N]) {
						crew.poll();
						// 막차 탑승인원 기록
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
			// 자리가 남으면 막차 시간만 맞추면 됨
			con = lastTime;
		} else {
			con = lastShuttle.peek() - 1;
		}
		
		
		answer = String.format("%02d:%02d", con / 60, con % 60);
		return answer;
	}
}
