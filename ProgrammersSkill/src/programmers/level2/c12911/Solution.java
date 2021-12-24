package programmers.level2.c12911;
// ���� ū ����
public class Solution {
	public int solution(int n) {
		int answer = n;
		int bit = 1;
		while (true) {
			// ���� bit�������� '01' bit�� Ž���Ͽ� '10' ���� �ٲپ���
			if ((answer & bit) == bit) {
				if ((answer & (bit << 1)) == 0) {
					answer += bit;
					// ����� bit���� ���� bit�� �����ϴ� '1' ��θ� ������ ������ �̵���Ŵ
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
