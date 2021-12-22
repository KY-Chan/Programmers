package programmers.level2.c42842;
// ī��
public class Solution {
	public int[] solution(int brown, int yellow) {
		int sum = brown / 2 + 2; // == a + b
		int mul = brown + yellow; // == ab
        // (a+b)^2 - 4ab = (a-b)^2, ���⿡ ��Ʈ ������ sum�� ���ϸ� 2a �� ��.
		int a = (int) (sum + Math.sqrt(sum * sum - 4 * mul)) / 2;
		int b = sum - a;
		int[] answer = { a, b };
		return answer;
	}
}
