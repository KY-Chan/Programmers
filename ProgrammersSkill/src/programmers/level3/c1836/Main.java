package programmers.level3.c1836;


public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int m ;
		int n ;
		String[] board = {"ABCDEFGHIJKLMNOPQRSTUVWXYZ","ABCDEFGHIJKLMNOPQRSTUVWXYZ"};
		m = board.length;
		n = board[0].length();
		System.out.println(sol.solution(m, n, board));
	}
	
}
