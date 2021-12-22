package test1_2;

public class Solution {
    public int solution(int n) {
    	double third = 0;
    	while(n != 0) {
    		third *= 10;
    		third += n % 3;
    		n = n / 3;
    	}
    	third = Math.floor(third);
    	System.out.println(String.format("%.3f", third));
    	double tenth = 0;
    	int stage = 1;
    	while(third != 0) {
    		tenth += (third % 10) * stage;
    		third = Math.floor(third / 10);
    		stage *= 3;
    	}
        int answer = (int) tenth;
        
        return answer;
    }
}