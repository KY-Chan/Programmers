package programmers.level3.c17676;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public int solution(String[] lines) {
		int size = lines.length;
		List<Integer> logs = new ArrayList<Integer>();
        for(int idx = 0; idx < size; idx++) {
        	
        	String[] tokens = lines[idx].split(" ");
        	String[] times = tokens[1].split(":");
        	String[] seconds1 = times[2].split("\\.");
        	int endTime = 36000000 * Integer.parseInt(times[0]) + 600000 * Integer.parseInt(times[1])
        	+ 10000 * Integer.parseInt(seconds1[0]) + 10 * Integer.parseInt(seconds1[1]);
        	String[] seconds2 = tokens[2].split("s")[0].split("\\.");
        	
        	int serviceTime = 10000 * + Integer.parseInt(seconds2[0]);
        	if(seconds2.length > 1) {
        		 serviceTime += 10 * Integer.parseInt(seconds2[1]);
        	}
        	int startTime = endTime - serviceTime - 10000 + 10;
        	logs.add(startTime + 1 + 40000);
        	logs.add(endTime + 40000);
        }
        logs.sort(null);
        int max = 0, count = 0;
        for(int log : logs) {
        	if(log % 10 == 1) {
        		count++;
        		max = Math.max(max, count);
        	} else {
        		count--;
        	}
        }
        return max;
    }
}
