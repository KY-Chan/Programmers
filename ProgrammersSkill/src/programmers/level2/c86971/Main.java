package programmers.level2.c86971;

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] wires = { { 1, 3 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 4, 6 }, { 4, 7 }, { 7, 8 }, { 7, 9 } };
		System.out.println(sol.solution(9, wires));
	}

}
