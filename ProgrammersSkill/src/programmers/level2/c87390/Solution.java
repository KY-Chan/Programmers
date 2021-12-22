package programmers.level2.c87390;
// n^2 배열 자르기
public class Solution {
	public int[] solution(int n, long left, long right) {
		int size = (int) (right - left + 1);
        int[] answer = new int[size];
        for(int i =0 ; i < size; i++) {
        	long remain = (left + i) % n;
        	long divide = (left + i) / n;
        	int number = (int) (remain < divide ? divide + 1 : remain +1) ;
        	answer[i] = number;
        }
        return answer;
    }
}
