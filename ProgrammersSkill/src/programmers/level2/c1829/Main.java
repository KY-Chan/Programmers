package programmers.level2.c1829;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] strs = {{1,1,1,2,2},
						{1,2,2,0,1}, 
						{1,2,4,2,1}, 
						{1,0,2,2,1}, 
						{2,1,1,1,1}};
		int[][] strs2 = {{1,1,1,0},
						 {1,1,1,0},
						 {0,0,0,1},
						 {0,0,0,1},
						 {0,0,0,1},
						 {0,0,0,1}};
		int[][] strs3 = new int[100][100];
		Arrays.fill(strs3[0], Integer.MAX_VALUE);
		int[] answer = sol.solution(100, 100, strs3);
		System.out.println(answer[0]);
		System.out.println(answer[1]);
		
		
	}

}
