package programmers.level3.c43163;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 단어 변환
public class Solution {
	public int solution(String begin, String target, String[] words) {
        int targetIndex = 0;
        // words에 없으면 0 return
        for(int idx = 0; idx < words.length; idx++) {
        	if(words[idx].equals(target)) {
        		targetIndex = idx + 1;
        	}
        }
        if(targetIndex == 0) {
        	return 0;
        }
        // 노드 생성
        List<ArrayList<Integer>> ways = new ArrayList<ArrayList<Integer>>();
        ways.add(way(begin, words));
        for(String word : words) {
        	ways.add(way(word,words));
        }
        
        // 단계 계산
        int[] distance = new int[words.length + 1];
        distance[0] = 0;
        for(int idx = 1; idx < words.length + 1; idx++) {
        	distance[idx] = 10000;
        }
        
        // DP BFS
        Queue<Integer> que = new LinkedList<Integer>();
        que.add(0);
        while(!que.isEmpty()) {
        	int curPos = que.poll();
        	ArrayList<Integer> way = ways.get(curPos);
        	for(int w : way) {
        		int nextCost = distance[curPos] + 1;
            	if(nextCost < distance[w]) {
            		distance[w] = nextCost;
            		que.add(w);
            	}
        	}
        }
        int answer = distance[targetIndex];
        return answer;
        
    }
	public ArrayList<Integer> way(String str, String[] words) {
		ArrayList<Integer> way = new ArrayList<Integer>();
		for(int idx = 0; idx < words.length; idx++) {
			int count = 0;
			char[] strChar = str.toCharArray();
			char[] wrdChar = words[idx].toCharArray();
			for(int pos = 0; pos < strChar.length; pos++) {
				if(strChar[pos] != wrdChar[pos]) {
					if(++count > 1) {
						break;
					}
				}
			}
			if(count == 1) {
				way.add(idx + 1); // begin offset
			}
		}
		return way;
	}
}
