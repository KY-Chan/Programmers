package programmers.level3.c43238;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
	/* https://programmers.co.kr/questions/17146 를 JAVA로 */	
	// 주어진 period 동안 심사관들이 처리할 수 있는 총 인원수
	//                        28 : answer, 6 : n
	// 테스트케이스의 경우 count(28, times) = 6 이다.
	public long count(long period, int[] times) {
		long cnt = 0;
		for(int time : times) {
			cnt += period / time;
		}
		return cnt;
	}
	public long solution(int n, int[] times) {
		// 2진수의 50 자리수부터 시작하여 최적의 숫자를 찾아냄
		// 테스트케이스의 경우 2^4 + 2^3 + 2^2 = 28 = 000...00011100(2)
		int digit = 50;
		long temp = 0;
		for(int idx = digit; idx > -1; idx--) {
			long answer = (long) (temp + Math.pow(2, idx));
			long cnt = count(answer, times);
			// 주어진 period (= answer) 동안 n명을 처리할 수 있는 경우
			if(cnt >= n) {
				// 그 중에서, answer - 1 분 동안에는 n명을 처리할 수 없는 경우
				// 즉, answer가 n명을 처리할 수 있는 최소값인 경우 return.
				if(count(answer - 1, times) < n) {
					return answer;
				}
			}
			// 주어진 period 동안 n명을 처리할 수 없는 경우
			// 즉 answer 가 2^idx 보다 크기 때문에, temp에 이 값을 더해줌.
			// 테스트케이스의 경우 아래 코드가 최초 수행됐을 때 temp는 000...00010000(2)
			else {
				temp = answer;
			}
		}
		return -1;
	}
	public long solution3(int n, int[] times) {
		// 분수 계산(times에 대해서 O(n) 하지만 double 정확도 문제)
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
		// PriorityQueue를 이용한 방법(실패 : O(n))
		long curTime = 0;
		Arrays.sort(times);
		Queue<long[]> wait = new PriorityQueue<long[]>(
				(o1, o2) -> Long.valueOf(o1[0] + o1[1] - o2[0] - o2[1]).intValue());

		for (long time : times) {
			long[] data = { time, 0 };
			wait.offer(data);
		}

		while (n > 0) {
			// 대기열 비어있음
			if (curTime == wait.peek()[1]) {
				long[] newWait = wait.poll();
				newWait[1] += newWait[0];
				wait.offer(newWait);
				// 마지막 사람일 경우
				if (--n == 0) {
					curTime += newWait[0];
				}
			}
			// 대기열 꽉참
			else {
				curTime = wait.peek()[1];
			}
		}
		return curTime;
	}
}
