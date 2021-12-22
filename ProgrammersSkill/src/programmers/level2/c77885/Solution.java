package programmers.level2.c77885;
// 2�� ���Ϸ� �ٸ� ��Ʈ
// ���� �������� "01" ��Ʈ�� �߰��ϸ� "10"���� �ٲ��ֱ�
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
