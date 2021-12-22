package programmers.level2.c42842;
// 카펫
public class Solution {
	public int[] solution(int brown, int yellow) {
		int sum = brown / 2 + 2; // == a + b
		int mul = brown + yellow; // == ab
        // (a+b)^2 - 4ab = (a-b)^2, 여기에 루트 씌워서 sum과 더하면 2a 가 됨.
		int a = (int) (sum + Math.sqrt(sum * sum - 4 * mul)) / 2;
		int b = sum - a;
		int[] answer = { a, b };
		return answer;
	}
}
