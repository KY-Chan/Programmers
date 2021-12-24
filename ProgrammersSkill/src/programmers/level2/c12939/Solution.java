package programmers.level2.c12939;

import java.util.Arrays;

public class Solution {
	public String solution(String s) {
		String[] ss = s.split(" ");
		int[] nums = new int[ss.length];
		for(int i =0 ; i < nums.length; i++) 
			nums[i] = Integer.parseInt(ss[i]);
		
		Arrays.sort(nums);
        String answer = "";
        answer += nums[0] + " ";
        answer += nums[nums.length - 1];
        return answer;
    }
}
