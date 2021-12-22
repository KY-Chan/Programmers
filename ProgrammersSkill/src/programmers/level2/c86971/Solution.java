package programmers.level2.c86971;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	public int solution(int n, int[][] wires) {
		int answer = -1;
		// ��� �Է�
		List<Set<Integer>> nodes = new ArrayList<Set<Integer>>();
		for (int i = 0; i <= n; i++)
			nodes.add(new HashSet<Integer>());
		for (int[] wire : wires) {
			nodes.get(wire[0]).add(wire[1]);
			nodes.get(wire[1]).add(wire[0]);
		}
		// ����ž�� ����� �������� ����
		Set<Integer> alive = new HashSet<Integer>();
		for (int i = 1; i <= n; i++)
			alive.add(i);
		// ������ �� �ϳ��ۿ� ���� ����ž��, �� ������ ����� ����ž�� ��ħ.
		// �������� ������� ����ž�� �ٿ�������, ������ ���� �� ���� ����.
		int stage = 1;
		int[] costs = new int[n + 1];
		for(int i = 1; i <=n; i++)
			costs[i] = 1;
		
		while(alive.size() != 2) {
			for(int i = 1; i <= n; i++) {
				if(nodes.get(i).size() == 1 && costs[i] == stage) {
					int next = nodes.get(i).iterator().next();
					costs[next] += costs[i];
					nodes.get(i).clear();
					nodes.get(next).remove(i);
					alive.remove(i);
					if(alive.size() == 2)
						break;
				}
			}
			stage++;
		}
		// Set�� ���� �� ���� ����ž ��ȣ�� ������ ���
		int[] compare = new int[2];
		int idx = 0;
		for(int a : alive)
			compare[idx++] = a;
		answer = Math.abs(costs[compare[0]] - costs[compare[1]]);
		return answer;
	}
}
