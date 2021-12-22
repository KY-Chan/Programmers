package programmers.level3.c43238;

// 입국심사
public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 2220;
		int[] times = {7, 10};
		int[] times2 = {3,4,5,6};
		System.out.println(sol.solution(n, times2));
		System.out.println(sol.solution2(n, times2));
	}
	
}
