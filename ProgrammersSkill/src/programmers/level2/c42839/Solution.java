package programmers.level2.c42839;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
// �Ҽ� ã��
public class Solution {
	public int solution(String numbers) {
        int answer = 0;
        // 1��
        // Set<Integer> numSet = makeSet(numbers);
        
        // 2��
        Set<Integer> numSet2 = new HashSet<Integer>();
        char[] numChar = numbers.toCharArray();
        int bit = (int) Math.pow(2, numChar.length) - 1;
        makeSet2(numSet2, numChar, bit, "");
        
        // �ִ밪 ������ �Ҽ� ���ϱ�
        int max = Collections.max(numSet2);
        int root = (int) Math.sqrt(max);
        boolean[] notPrime = new boolean[max + 1];
        notPrime[0] = notPrime[1] = true;
        
        for(int i = 2; i <= root; i++) {
        	int j = 2;
        	while(i * j <= max) {
        		notPrime[i * j] = true;
        		j++;
        	}
        }
        
        for(int num : numSet2) {
        	if(!notPrime[num]) {
        		answer++;
        	}
        }
        return answer;
    }
	// 1�� : parameter�� ���ο� Set<Character> �����ؼ� �Ѱ���
	public Set<Integer> makeSet(String numbers) {
		Set<Integer> numSet = new HashSet<Integer>();
		char[] charArray = numbers.toCharArray();
		Set<Character> charSet = new HashSet<Character>();
		for(char c : charArray) {
			charSet.add(c);
		}
		makeInt(numSet, charSet, "");
		return numSet;
	}
	public void makeInt(Set<Integer> numSet, Set<Character> charSet, String number) {
		for(char c : charSet) {
			String numCur = number;
			numCur += c;
			numSet.add(Integer.parseInt(numCur));
			Set<Character> charSetCur = new HashSet<Character>(charSet);
			charSetCur.remove(c);
			makeInt(numSet, charSetCur, numCur);
		}
	}
	
	// 2�� : ��Ʈ �������� char[] ���� ���� ���� Ȯ��. 1�Ⱥ��� �ι� �̻� ����
	public void makeSet2(Set<Integer> numSet, char[] numChar, int bit, String number) {
		if(number.length() > 0) {
			numSet.add(Integer.parseInt(number));
		}
		if((bit & 511) != 0) { // 9�ڸ��� ���� ����.
			int b = 1;
			for(int i = 0; i < numChar.length; i++) {
				if((bit & b) == b) {
					makeSet2(numSet, numChar, bit - b, number + numChar[i]);
				}
				b *= 2;
			}
		}
	}
}
