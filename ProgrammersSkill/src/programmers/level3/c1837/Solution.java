package programmers.level3.c1837;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// GPS
// https://softworking.tistory.com/417
// ������ ����� �α״�� �̵��� ��� 0, �ƴ� ��� 1.
public class Solution {
	public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
		List<List<Integer>> edgeList = new ArrayList<List<Integer>>();
		for (int i = 0; i <= n; i++)
			edgeList.add(new ArrayList<Integer>());
		for (int[] edge : edge_list) {
			edgeList.get(edge[0]).add(edge[1]);
			edgeList.get(edge[1]).add(edge[0]);
		}
		int[][] costArray = new int[k][n + 1];
		for( int i = 0; i < k; i++)
			Arrays.fill(costArray[i], 10000000);
		costArray[0][gps_log[0]] = 0;

		// �� ��° �α׺��� Ž��
		for (int i = 1; i < k; i++) {
			for (int j = 1; j <= n; j++) {
				// �������� ���� ���
				costArray[i][j] = Math.min(costArray[i - 1][j],  costArray[i][j]);
				
				for(int next : edgeList.get(j))
					costArray[i][j] = Math.min(costArray[i - 1][next], costArray[i][j]);
					
				if(gps_log[i] != j)
					costArray[i][j] += 1;
				
			}
		}
		int answer = costArray[k - 1][gps_log[k - 1]];
		return answer < 10000000 ? answer : -1;
	}
}
