package programmers.level3.c76503;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// ��� 0���� �����
public class Solution {
	public long solution(int[] a, int[][] edges) {
		long count = 0;
		Map<Integer, Set<Integer>> nodes = new HashMap<Integer, Set<Integer>>();
		long[] aLong = new long[a.length];
		// �� ��� ����
		for (int i = 0; i < a.length; i++) {
			nodes.put(i, new HashSet<Integer>());
			aLong[i] = a[i];
		}
		// ���� �Է�
		for (int[] edge : edges) {
			nodes.get(edge[0]).add(edge[1]);
			nodes.get(edge[1]).add(edge[0]);
		}
		// ������ �ϳ����� ��常 que�� ���
		Queue<Integer> que = new LinkedList<Integer>();
		for (int key : nodes.keySet())
			if (nodes.get(key).size() == 1)
				que.add(key);
		// Ʈ���� ���ܺ��� �ٿ�����
		while (!que.isEmpty() && nodes.size() > 1) {
			int i = que.poll();
			int parent = nodes.get(i).iterator().next();
			count += Math.abs(aLong[i]);
			aLong[parent] += aLong[i];
			nodes.remove(i);
			nodes.get(parent).remove(i);
			// ������ �ٿ����� ������ �� ���
			if (nodes.get(parent).size() == 1)
				que.add(parent);
		}
		if (aLong[nodes.keySet().iterator().next()] == 0)
			return count;
		else
			return -1;
	}
}
