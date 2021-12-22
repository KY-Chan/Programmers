package programmers.level3.c17676;

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] strs1 = {
				"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"
		};
		String[] strs2 = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
		System.out.println(sol.solution(strs1));
		System.out.println(sol.solution(strs2));
	}

}
