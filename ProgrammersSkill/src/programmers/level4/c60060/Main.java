package programmers.level4.c60060;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
		String[] queries = {"?????"};
		System.out.println(Arrays.toString(sol.solution(words, queries)));
	}
	
}
