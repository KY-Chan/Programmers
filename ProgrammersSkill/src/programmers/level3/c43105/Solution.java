package programmers.level3.c43105;

public class Solution {
	public int solution(int[][] triangle) {
		int answer = 0;
		int size = triangle.length;

		for (int depth = 1; depth < size; depth++) {
			for (int idx = 0; idx <= depth; idx++) {
				int left = 0, right = 0;
				if (idx > 0) { // 왼쪽 부모 가져오기
					left = triangle[depth - 1][idx - 1];
				}
				if (idx < depth) { // 오른쪽 부모 가져오기
					right = triangle[depth - 1][idx];
				}
				triangle[depth][idx] += Math.max(left, right);
			}
		}
		for(int idx = 0; idx < size; idx++) {
			answer = Math.max(answer, triangle[size - 1][idx]);
		}
		return answer;
	}
}
