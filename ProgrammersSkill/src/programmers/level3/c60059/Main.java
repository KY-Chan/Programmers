package programmers.level3.c60059;

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		//int[][] key = { { 0, 0, 0 }, { 1, 0, 0}, { 0, 0, 0} };
		int[][] key = { { 1}};
		int[][] lock = { { 1} };
		System.out.println(sol.solution(key, lock));
	}

}
