
package skill2_329019;

import java.util.Arrays;

public class Solution {
	public boolean solution(String[] phone_book) {
		boolean answer = true;
		Arrays.sort(phone_book);
		for (int idx = 0; idx < phone_book.length - 1; idx++) {
			if(phone_book[idx].length() > phone_book[idx + 1].length()) {
				continue;
			}
			String nextBook = phone_book[idx + 1].substring(0, phone_book[idx].length());
			if (phone_book[idx].equals(nextBook)) {
				answer = false;
			}
		}
		return answer;
	}
}
