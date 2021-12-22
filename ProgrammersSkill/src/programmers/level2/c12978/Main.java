package programmers.level2.c12978;


public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] road = {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};
		System.out.println(sol.solution(6, road, 4));
	}
	
}
