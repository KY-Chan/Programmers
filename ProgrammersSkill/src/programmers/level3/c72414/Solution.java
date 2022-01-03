package programmers.level3.c72414;

public class Solution {
	public String solution(String play_time, String adv_time, String[] logs) {
		// parameter�� int�� ��ȯ
		int playSec = toSeconds(play_time);
		int advSec = toSeconds(adv_time);
		// �ʸ��� ��û �ο���
		int[] logSec = new int[360000];
		for (String log : logs) {
			int start = toSeconds(log.substring(0, 8));
			int end = toSeconds(log.substring(9));
			for (int i = start; i < end; i++)
				logSec[i]++;
		}
		// ���� ��û �ð��� �� ���� Ž��
		int sIdx = 0;
		int maxIdx = 0;
		long view = 0;
		long maxView = 0;
		int length = 0;
		for (int i = 0; i < logSec.length; i++) {
			if (length >= advSec) {
				if (maxView < view) {
					maxView = view;
					maxIdx = sIdx;
				}
				view -= logSec[sIdx++];
			} else
				length++;
			view += logSec[i];
		}

		int hh = maxIdx / 3600;
		int mm = (maxIdx / 60) % 60;
		int ss = maxIdx % 60;

		String answer = String.format("%02d:%02d:%02d", hh, mm, ss);
		return answer;
	}

	// HH:MM:SS �� seconds �� ��ȯ
	public int toSeconds(String hms) {
		int seconds = Integer.parseInt(hms.substring(0, 2)) * 3600;
		seconds += Integer.parseInt(hms.substring(3, 5)) * 60;
		seconds += Integer.parseInt(hms.substring(6, 8));
		return seconds;
	}
}
