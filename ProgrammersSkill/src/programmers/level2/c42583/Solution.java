package programmers.level2.c42583;

import java.util.HashMap;
import java.util.Map;
// �ٸ��� ������ Ʈ��
public class Solution {
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int cur = 0;
        Map<Integer, Integer> log = new HashMap<Integer, Integer>();
        for(int truck : truck_weights) {
        	// Ʈ���� ���� �� �ִ� �ð����� �̵�
        	while(log.getOrDefault(cur, 0) + truck > weight)
        		cur++;
        	// Ʈ���� �������� �ð� ���� ����
        	for(int i = 0; i < bridge_length; i++)
        		log.merge(cur + i, truck, (total, add) -> total + add);
        	
        	cur++;
        }
        // cur�� ������ Ʈ���� ����� �ð� + 1 �̸� ���⿡ �ٸ����̸� ���ϸ� �����ð��� �ȴ�.
        answer = cur + bridge_length;
        return answer;
    }
}
