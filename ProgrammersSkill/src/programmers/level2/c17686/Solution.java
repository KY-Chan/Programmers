package programmers.level2.c17686;

import java.util.Arrays;
// ���ϸ� ����
public class Solution {
	public String[] solution(String[] files) {
		// ���� ������ �ƴϱ⿡ index �߰��صα�
		for(int i = 0 ; i< files.length; i++) 
			files[i] += "!" + i;
		
		Arrays.sort(files, (a, b) -> {
			// head ����
			String[] aTmp = a.split("\\d+");
			String[] bTmp = b.split("\\d+");
			int head = aTmp[0].compareToIgnoreCase(bTmp[0]);
			
			if(head != 0) // head ��������
				return head;
			else { // head�� ����
				// number ����
				int aLen = Integer.parseInt(a.split("\\D+")[1]);
				int bLen = Integer.parseInt(b.split("\\D+")[1]);
				if(aLen != bLen) // number ��������
					return aLen - bLen;
				else { // number ����
					return Integer.parseInt(a.split("!")[1]) - Integer.parseInt(b.split("!")[1]);
				}
			}
		});
		// index ����
		for(int i = 0 ; i< files.length; i++) 
			files[i] = files[i].split("!")[0];
		return files;
	}
}
