package programmers.level2.c72411;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// 메뉴 리뉴얼
// combination 조합
public class Solution {
	public String[] solution(String[] orders, int[] course) {
		Map<String, Integer> allCourse = new HashMap<String, Integer>();
		Map<Integer, Integer> maxCourse = new HashMap<Integer, Integer>();
		List<String> resultCourse = new ArrayList<String>();
		// 코스 종류 미리 입력
		for(int c : course) {
			maxCourse.put(c, 0);
		}
		// 가능한 모든 조합 생성
		for(String order : orders) {
			char[] orderChar = order.toCharArray();
			Arrays.sort(orderChar);
			order = new String(orderChar);
			generateCourse(allCourse, maxCourse, order, "");
		}
		// 유효한 코스만 저장
		for(String key : allCourse.keySet()) {
			if(allCourse.get(key) == maxCourse.getOrDefault(key.length(), 0)) {
				if(maxCourse.get(key.length()) > 1) {
					resultCourse.add(key);
				}
			}
		}
		// 출력
		String[] answer = resultCourse.stream().sorted().toArray(String[]::new);
		return answer;
    }
	public void generateCourse(Map<String, Integer> allCourse, Map<Integer, Integer> maxCourse, String order, String newOrder) {
		for(int i = 0; i < order.length(); i++) {
			String curOrder = newOrder + order.charAt(i);
			if(maxCourse.getOrDefault(curOrder.length(), -1) >= 0) {
				int count = allCourse.merge(curOrder, 1, (total, add) -> total + add);
				maxCourse.merge(curOrder.length(), count, (oldV, newV) -> oldV > newV ? oldV : newV);
			}
			generateCourse(allCourse, maxCourse, order.substring(i + 1), curOrder);
		}
	}
}
