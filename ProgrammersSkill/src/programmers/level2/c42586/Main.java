package programmers.level2.c42586;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] progresses = { 95,90,99,99,80,99 };
		int[] speeds = { 1,1,1,1,1,1 };
		System.out.println(Arrays.toString(sol.solution(progresses, speeds)));
	}

}
