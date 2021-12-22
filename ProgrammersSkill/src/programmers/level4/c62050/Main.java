package programmers.level4.c62050;


public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] land = {{1, 4, 8, 10}, 
		                {5, 5, 5, 5},
		                {10, 10, 10, 10},
		                {10, 10, 10, 20}};
		int[][] land2 = {{10, 11, 10, 11},
						{2, 21, 20, 10}, 
						{1, 20, 21, 11},
						{2, 1, 2, 1}};
		int[][] land3 = {{1,1,1,1,1},
						 {1,101,91,101,1},
						 {1,101,1,101,1},
						 {1,101,81,101,1},
						 {1,1,1,1,1}
						};
		int[][] land4 = {{101,101,101,101,101},
				 		{101,1,91,1,101},
				 		{101,1,101,1,101},
				 		{101,1,81,1,101},
				 		{101,101,101,101,101}
						};
		int height = 3;
		int height2 = 1;
		System.out.println(sol.solution(land2, 1));
	}
	
}
