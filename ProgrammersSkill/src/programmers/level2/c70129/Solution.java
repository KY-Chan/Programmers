package programmers.level2.c70129;
// 이진 변환 반복하기
public class Solution {
	public int[] solution(String s) {
		int stage = 0;
		int count = 0;
		while(s.length() !=1) {
			char[] chr = s.toCharArray();
			int high = 0;
			String s2 = "";
			for(char c : chr) {
				if(c == '0')
					count++;
				else
					high++;
			}
			s = Integer.toBinaryString(high);
			System.out.println(s);
			stage++;
		}
        int[] answer = {stage, count};
        return answer;
    }
}
