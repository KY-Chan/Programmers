package programmers.level3.c43164;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		Solution2 sol2 = new Solution2();
		
		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		//System.out.println(Arrays.toString(sol.solution(tickets)));
		System.out.println(Arrays.toString(sol2.solution(tickets)));
	}
	
}
