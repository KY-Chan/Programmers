package programmers.level2.c42586;

import java.util.ArrayList;
import java.util.List;

// 기능 개발
public class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		int size = progresses.length;
        int[] periods = new int[size];
        for(int idx = 0; idx < size; idx++) {
        	periods[idx] = (int) Math.ceil((100.0 - progresses[idx]) / speeds[idx]);
        }
        List<Integer> answerList = new ArrayList<Integer>();
        int tempMax = periods[0];
        int count = 0;
        for(int period : periods) {
        	if(tempMax >= period) {
        		count++;
        	} else {
        		answerList.add(count);
        		count = 1;
        		tempMax = period;
        	}
        }
		answerList.add(count);
        int[] answer = new int[answerList.size()];
        for(int idx = 0; idx < answer.length; idx++) {
        	answer[idx] = answerList.get(idx);
        }
        return answer;
    }
}
