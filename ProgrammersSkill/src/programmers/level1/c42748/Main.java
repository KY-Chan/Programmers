package programmers.level1.c42748;

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		System.out.println(sol.solution(array, commands));
	}

}
