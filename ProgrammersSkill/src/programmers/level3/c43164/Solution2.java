package programmers.level3.c43164;

import java.util.Arrays;
import java.util.Stack;

// 여행 경로
// dfs 다른 정답
public class Solution2 {
	Stack<String> answers = new Stack<String>();

	public String[] solution(String[][] tickets) {
		boolean[] chk = new boolean[tickets.length];
		Arrays.sort(tickets, (o1, o2) -> {return o1[0].equals(o2[0]) ? o1[1].compareTo(o2[1]) : o1[0].compareTo(o2[0]);});
		dfs("ICN", tickets, chk, 0);
		
		String[] answer = {};
		answer = answers.toArray(answer);
		return answer;
	}

	public boolean dfs(String go, String[][] tickets, boolean[] chk, int cnt) {
		answers.push(go);
		if (cnt == tickets.length)
			return true;
		for (int i = 0; i < tickets.length; i++) {
			if (tickets[i][0].equals(go) && !chk[i]) {
				chk[i] = true;
				boolean is_true = dfs(tickets[i][1], tickets, chk, cnt + 1);
				if (is_true)
					return true;
				chk[i] = false;
			}
		}
		answers.pop();
		return false;
	}
}
