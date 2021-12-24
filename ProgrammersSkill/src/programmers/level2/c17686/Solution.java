package programmers.level2.c17686;

import java.util.Arrays;
// 파일명 정렬
public class Solution {
	public String[] solution(String[] files) {
		// 안정 정렬이 아니기에 index 추가해두기
		for(int i = 0 ; i< files.length; i++) 
			files[i] += "!" + i;
		
		Arrays.sort(files, (a, b) -> {
			// head 추출
			String[] aTmp = a.split("\\d+");
			String[] bTmp = b.split("\\d+");
			int head = aTmp[0].compareToIgnoreCase(bTmp[0]);
			
			if(head != 0) // head 오름차순
				return head;
			else { // head가 동일
				// number 추출
				int aLen = Integer.parseInt(a.split("\\D+")[1]);
				int bLen = Integer.parseInt(b.split("\\D+")[1]);
				if(aLen != bLen) // number 오름차순
					return aLen - bLen;
				else { // number 동일
					return Integer.parseInt(a.split("!")[1]) - Integer.parseInt(b.split("!")[1]);
				}
			}
		});
		// index 제거
		for(int i = 0 ; i< files.length; i++) 
			files[i] = files[i].split("!")[0];
		return files;
	}
}
