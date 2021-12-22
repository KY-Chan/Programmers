package programmers.level1.c77484;

public class Solution {
	public int[] solution(int[] lottos, int[] win_nums) {
        int wild = 0;
        int hit = 0;
        for(int i = 0; i < 6; i++) {
        	if(lottos[i] == 0) {
        		wild++;
        		continue;
        	}
        	for(int j = 0; j < 6; j++) {
        		if(lottos[i] == win_nums[j]) {
        			hit++;
        			break;
        		}
        	}
        }
        int max = (hit + wild) < 2 ? 6 : 7 - hit - wild;
        int min = hit < 1 ? 6 : 7 - hit;
        
        int[] answer = {max, min};
        return answer;
    }
}
