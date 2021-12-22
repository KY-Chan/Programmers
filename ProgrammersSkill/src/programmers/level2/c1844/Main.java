package programmers.level2.c1844;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		//int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		
		int[][] maps = new int[100][100];
		for(int[] map : maps) {
			Arrays.fill(map, 1);
		}
		System.out.println(sol.solution(maps));
	}
	
}
