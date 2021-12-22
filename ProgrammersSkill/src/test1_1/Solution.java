package test1_1;

public class Solution {
    public int[] solution(int n, int m) {
    	int n1 = n, n2 = m;
    	while(n2!= 0) {
    		int temp = n1 % n2;
    		n1 = n2;
    		n2 = temp;
    	}
        int[] answer = {n1, n * m / n1 };
        return answer;
    }
}