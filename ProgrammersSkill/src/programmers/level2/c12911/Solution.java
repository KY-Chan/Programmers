package programmers.level2.c12911;
// 다음 큰 숫자
public class Solution {
	public int solution(int n) {
		int answer = n;
		int bit = 1;
		while (true) {
			// 낮은 bit에서부터 '01' bit를 탐색하여 '10' 으로 바꾸어줌
			if ((answer & bit) == bit) {
				if ((answer & (bit << 1)) == 0) {
					answer += bit;
					// 변경된 bit보다 낮은 bit에 존재하는 '1' 모두를 오른쪽 끝으로 이동시킴
					int remains = (answer & (bit - 1));
					answer -= remains;
					while ((remains & 1) == 0 && remains != 0) 
						remains >>=1;
					answer += remains;
					break;
				}
			}
			bit <<= 1;
		}
		return answer;
	}
}
