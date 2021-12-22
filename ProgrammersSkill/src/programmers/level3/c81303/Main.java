package programmers.level3.c81303;

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 8;
		int k = 2;
		String[] cmd = { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z" };
		System.out.println(sol.solution(n, k, cmd));
	}

}
