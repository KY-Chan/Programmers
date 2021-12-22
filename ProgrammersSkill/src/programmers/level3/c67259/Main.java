package programmers.level3.c67259;


public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int board[][] = {{0,0,0},
						 {0,0,0},
						 {0,0,0}};
		int board2[][] = {{0,0,0,0,0,0,0,1},
		                 {0,0,0,0,0,0,0,0},
		                 {0,0,0,0,0,1,0,0},
		                 {0,0,0,0,1,0,0,0},
		                 {0,0,0,1,0,0,0,1},
		                 {0,0,1,0,0,0,1,0},
		                 {0,1,0,0,0,1,0,0},
		                 {1,0,0,0,0,0,0,0}};
		int board3[][] = {{0,0,1,0},
		                  {0,0,0,0},
		                  {0,1,0,1},
		                  {1,0,0,0}};
		int board4[][] = {{0,0,0,0,0,0},
		                  {0,1,1,1,1,0},
		                  {0,0,1,0,0,0},
		                  {1,0,0,1,0,1},
		                  {0,1,0,0,0,1},
		                  {0,0,0,0,0,0}};
		System.out.println(sol.solution(board3));
	}
	
}
