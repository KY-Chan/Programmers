package programmers.level2.c42583;

import java.util.HashMap;
import java.util.Map;
// 다리를 지나는 트럭
public class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int cur = 0;
        Map<Integer, Integer> log = new HashMap<Integer, Integer>();
        for(int truck : truck_weights) {
        	// 트럭이 지날 수 있는 시간까지 이동
        	while(log.getOrDefault(cur, 0) + truck > weight)
        		cur++;
        	// 트럭이 지나가는 시간 범위 저장
        	for(int i = 0; i < bridge_length; i++)
        		log.merge(cur + i, truck, (total, add) -> total + add);
        	
        	cur++;
        }
        // cur은 마지막 트럭이 출발한 시간 + 1 이며 여기에 다리길이를 더하면 도착시간이 된다.
        answer = cur + bridge_length;
        return answer;
    }
}
