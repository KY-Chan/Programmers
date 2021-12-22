package programmers.level3.c81303;

import java.util.Stack;

public class Solution {
	public String solution(int n, int k, String[] cmd) {
		char[] ox = new char[n];
		Stack<int[]> logs = new Stack<int[]>();
		int[][] table = new int[n][2];
		for (int i = 0; i < n; i++) {
			ox[i] = 'O';
			table[i][0] = i - 1;
			table[i][1] = i + 1;
		}
		for (String c : cmd) {
			char command = c.charAt(0);
			if (command == 'D') { // �Ʒ�
				int num = Integer.parseInt(c.split(" ")[1]);
				for (int i = 0; i < num; i++) {
					k = table[k][1];
				}
			} else if (command == 'U') { // ��
				int num = Integer.parseInt(c.split(" ")[1]);
				for (int i = 0; i < num; i++) {
					k = table[k][0];
				}
			} else if (command == 'C') { // ����
				int[] log = {k, table[k][0], table[k][1]};
				logs.add(log);
				if(table[k][0] >= 0) {
					table[table[k][0]][1] = table[k][1]; // ��ĭ�� �Ʒ����� index�� �� �Ʒ����� index��
					
				}
				if(table[k][1] < n) {
					table[table[k][1]][0] = table[k][0]; // �Ʒ�ĭ�� ������ index�� �� ������ index��
				}
//				System.out.println("delete " + k);
				k = table[k][1] != n ? table[k][1] : table[k][0];
			} else { // ����
				int[] log = logs.pop();
//				System.out.println(Arrays.toString(log));
				if(log[1] >= 0) {
					table[log[1]][1] = log[0];
				}
				if(log[2] < n) {
					table[log[2]][0] = log[0];
				}
			}
//			System.out.print("K : " + k);
//			for(int[] t : table) {
//				System.out.print(Arrays.toString(t));
//			}
//			System.out.println();
		}
		for(int[] log : logs) {
			ox[log[0]] = 'X';
		}

		String answer = new String(ox);
		return answer;
	}
}
