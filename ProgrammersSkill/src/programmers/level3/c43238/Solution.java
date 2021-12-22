package programmers.level3.c43238;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
	/* https://programmers.co.kr/questions/17146 �� JAVA�� */	
	// �־��� period ���� �ɻ������ ó���� �� �ִ� �� �ο���
	//                        28 : answer, 6 : n
	// �׽�Ʈ���̽��� ��� count(28, times) = 6 �̴�.
	public long count(long period, int[] times) {
		long cnt = 0;
		for(int time : times) {
			cnt += period / time;
		}
		return cnt;
	}
	public long solution(int n, int[] times) {
		// 2������ 50 �ڸ������� �����Ͽ� ������ ���ڸ� ã�Ƴ�
		// �׽�Ʈ���̽��� ��� 2^4 + 2^3 + 2^2 = 28 = 000...00011100(2)
		int digit = 50;
		long temp = 0;
		for(int idx = digit; idx > -1; idx--) {
			long answer = (long) (temp + Math.pow(2, idx));
			long cnt = count(answer, times);
			// �־��� period (= answer) ���� n���� ó���� �� �ִ� ���
			if(cnt >= n) {
				// �� �߿���, answer - 1 �� ���ȿ��� n���� ó���� �� ���� ���
				// ��, answer�� n���� ó���� �� �ִ� �ּҰ��� ��� return.
				if(count(answer - 1, times) < n) {
					return answer;
				}
			}
			// �־��� period ���� n���� ó���� �� ���� ���
			// �� answer �� 2^idx ���� ũ�� ������, temp�� �� ���� ������.
			// �׽�Ʈ���̽��� ��� �Ʒ� �ڵ尡 ���� ������� �� temp�� 000...00010000(2)
			else {
				temp = answer;
			}
		}
		return -1;
	}
	public long solution3(int n, int[] times) {
		// �м� ���(times�� ���ؼ� O(n) ������ double ��Ȯ�� ����)
		long answer = 0;
		long sum = 0;
		double mul = 0;
		for (int time : times) {
			mul += 1D / time;
		}
		long[] answers = new long[times.length];
		for (int idx = 0; idx < times.length; idx++) {
			answers[idx] = times[idx] * Math.round(n / mul / times[idx]);
		}
		Arrays.sort(answers);
		answer = answers[answers.length - 1];
		return answer;
	}

	public long solution2(int n, int[] times) {
		// PriorityQueue�� �̿��� ���(���� : O(n))
		long curTime = 0;
		Arrays.sort(times);
		Queue<long[]> wait = new PriorityQueue<long[]>(
				(o1, o2) -> Long.valueOf(o1[0] + o1[1] - o2[0] - o2[1]).intValue());

		for (long time : times) {
			long[] data = { time, 0 };
			wait.offer(data);
		}

		while (n > 0) {
			// ��⿭ �������
			if (curTime == wait.peek()[1]) {
				long[] newWait = wait.poll();
				newWait[1] += newWait[0];
				wait.offer(newWait);
				// ������ ����� ���
				if (--n == 0) {
					curTime += newWait[0];
				}
			}
			// ��⿭ ����
			else {
				curTime = wait.peek()[1];
			}
		}
		return curTime;
	}
}
