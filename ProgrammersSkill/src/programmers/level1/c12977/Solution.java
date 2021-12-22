package programmers.level1.c12977;

import java.util.Arrays;

// 소수 만들기
public class Solution {
	public int solution(int[] nums) {
		int answer = 0;
		int size = nums.length;
		Arrays.sort(nums);
		int max = nums[size - 3] + nums[size - 2] + nums[size - 1];
		boolean[] notPrimes = new boolean[max + 1];
		for (int i = 2; i <= Math.sqrt(max); i++) {
			int k = 2;
			while (i * k <= max) 
				notPrimes[i * (k++)] = true;
		}
		
		for(int i = 0; i < size - 2; i++) {
			for(int j = i + 1; j < size - 1; j++) {
				for(int k = j + 1; k < size; k++) {
					int check = nums[i] + nums[j] + nums[k];
					if(!notPrimes[check])
						answer++;
				}
			}
		}
		return answer;
	}
}
