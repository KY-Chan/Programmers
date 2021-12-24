package programmers.level1.c42862;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = n;
		Set<Integer> remains = new HashSet<Integer>();
		Set<Integer> losts = new HashSet<Integer>();
		for(int res : reserve)
			remains.add(res);
		for(int l : lost)
			if(!remains.remove(l))
				losts.add(l);
		
		for(int l : losts) {
			if(remains.contains(l - 1))
				remains.remove(l - 1);
			else if(remains.contains(l + 1))
				remains.remove(l + 1);
			else
				answer--;
		}
		return answer;
	}
}
