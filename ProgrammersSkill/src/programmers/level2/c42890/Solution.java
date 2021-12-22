package programmers.level2.c42890;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
// �ĺ�Ű
// ���� combination
public class Solution {
	public int solution(String[][] relation) {
		int answer = 0;
		int row = relation.length;
		int col = relation[0].length;
		Set<List<Integer>> allCombination = new HashSet<List<Integer>>();
		List<List<Integer>> availableKey = new ArrayList<List<Integer>>();
		// �ĺ�Ű ���� ����
		makeCombination(allCombination, new ArrayList<Integer>(), col, 0);
		// �ĺ�Ű ���� ���� �˻�
		for (List<Integer> candidateKey : allCombination) {
			// ������ Ű�� �ߺ����� ���ٸ� �ĺ�Ű ����
			Set<String> check = new HashSet<String>();
			for (String[] tuple : relation) {
				String key = "";
				for (int idx : candidateKey) {
					key += tuple[idx];
				}
				check.add(key);
			}
			if (check.size() == row) {
				availableKey.add(candidateKey);
			}
		}
		// ���� �ĺ�Ű ��
		availableKey.sort((o1, o2) -> o1.size() - o2.size());
		while (!availableKey.isEmpty()) {
			List<Integer> key = availableKey.remove(0);
			answer++;
			int idx = 0;
			while (idx < availableKey.size()) {
				if (availableKey.get(idx).containsAll(key)) {
					availableKey.remove(idx);
				} else {
					idx++;
				}
			}
		}
		return answer;
	}

	public void makeCombination(Set<List<Integer>> allCombination, List<Integer> cur, int col, int idx) {
		for (int i = idx; i < col; i++) {
			List<Integer> next = new ArrayList<Integer>(cur);
			next.add(i);
			allCombination.add(next);
			makeCombination(allCombination, next, col, i + 1);
		}
	}
}
