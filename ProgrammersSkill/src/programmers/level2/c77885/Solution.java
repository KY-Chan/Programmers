package programmers.level2.c77885;
// 2개 이하로 다른 비트
// 가장 오른쪽의 "01" 비트를 발견하면 "10"으로 바꿔주기
// ex) ..00100011111 -> ..00100101111
public class Solution {
	public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
        	long bit = 1;
        	while((numbers[i] & bit) == bit)
        		bit <<= 1;
        	if(bit != 1)
        		bit >>= 1;
        	answer[i] = numbers[i] + bit ;
        }
        return answer;
    }
}
