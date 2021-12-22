package programmers.level3.c1837;


public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] edge_list = {{1, 2}, {1, 3}, {2, 3}, {2, 4}, {3, 4}, {3, 5}, {4, 6}, {5, 6}, {5, 7}, {6, 7}};
		int[] gps_log = {1,2,3,4,5,7};
		System.out.println(sol.solution(7, 10, edge_list, 6, gps_log));
	}
	
}
