package programmers.level2.c42839;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
// 소수 찾기
public class Solution {
	public int solution(String numbers) {
        int answer = 0;
        // 1안
        // Set<Integer> numSet = makeSet(numbers);
        
        // 2안
        Set<Integer> numSet2 = new HashSet<Integer>();
        char[] numChar = numbers.toCharArray();
        int bit = (int) Math.pow(2, numChar.length) - 1;
        makeSet2(numSet2, numChar, bit, "");
        
        // 최대값 까지의 소수 구하기
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
	// 1안 : parameter로 새로운 Set<Character> 생성해서 넘겨줌
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
	
	// 2안 : 비트 연산으로 char[] 원소 선택 여부 확인. 1안보다 두배 이상 빠름
	public void makeSet2(Set<Integer> numSet, char[] numChar, int bit, String number) {
		if(number.length() > 0) {
			numSet.add(Integer.parseInt(number));
		}
		if((bit & 511) != 0) { // 9자리수 까지 가능.
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
