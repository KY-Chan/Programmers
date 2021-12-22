package programmers.level1.c86051;

public class Solution {
	public int solution(int[] numbers) {
        int answer = 55;
        for(int n : numbers)
        	answer -= n;
        return answer;
    }
}
