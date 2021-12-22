package programmers.level3.c77486;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
		int[] amount = {12, 4, 2, 5, 10};
		int[] result = {360, 958, 108, 0, 450, 18, 180, 1080};
		System.out.println(Arrays.toString(sol.solution(enroll, referral, seller, amount)));
		System.out.println(Arrays.toString(result));
	}
	
}
