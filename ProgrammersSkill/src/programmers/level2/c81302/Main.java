package programmers.level2.c81302;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
		                     {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
		                     {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
		                     {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
		                     {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		System.out.println(Arrays.toString(sol.solution(places)));
	}
	
}
