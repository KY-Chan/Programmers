package programmers.level3.c64064;


public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
		System.out.println(sol.solution(user_id, banned_id));
	}
	
}
