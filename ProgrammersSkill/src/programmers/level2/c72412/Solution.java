package programmers.level2.c72412;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public int[] solution(String[] info, String[] query) {
		// map 형태로 테이블에 입력
		Map<Integer, List<Integer>> table = new HashMap<Integer, List<Integer>>();
		for (String inf : info) {
			int[] data = parseInf(inf); // { bit Key, score }
			if (table.containsKey(data[0]))
				table.get(data[0]).add(data[1]);
			else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(data[1]);
				table.put(data[0], list);
			}
		}

		// 테이블 정렬
		for (int key : table.keySet())
			table.get(key).sort(null);

		int[] answer = new int[query.length];
		// 쿼리 실행 결과
		for (int i = 0; i < query.length; i++) {
			int[] data = parseInf(query[i].replace("and ", ""));
			for (int key : table.keySet()) {
				if ((key & data[0]) == key) {
					List<Integer> selected = table.get(key);
					int low = 0;
					int high = selected.size() - 1;
					int mid = 0;
					boolean found = false;
					while (low <= high) {
						mid = (low + high) >>> 1;
						int midVal = selected.get(mid);

						if (midVal < data[1])
							low = mid + 1;
						else if (midVal > data[1])
							high = mid - 1;
						else {
							if(mid > 0) {
								if(selected.get(mid - 1) == data[1]) {
									high = mid - 1;
									continue;
								}
							}
							found = true;
							break;
						}
					}
					if(!found)
						mid = low;

					answer[i] += selected.size() - mid;
				}
			}
		}
		return answer;

	}

	public int[] parseInf(String inf) {
		int key = 0;
		String[] words = inf.split(" ");

		if (words[0].charAt(0) == '-') // wildcard
			key += 448;
		else if (words[0].charAt(0) == 'c') // c++
			key += 256;
		else if (words[0].charAt(0) == 'j')// java
			key += 128;
		else // python
			key += 64;

		if (words[1].charAt(0) == '-') // wildcard
			key += 48;
		else if (words[1].charAt(0) == 'b') // backend
			key += 32;
		else // frontend
			key += 16;

		if (words[2].charAt(0) == '-') // wildcard
			key += 12;
		else if (words[2].charAt(0) == 'j') // junior
			key += 8;
		else // senior
			key += 4;

		if (words[3].charAt(0) == '-') // wildcard
			key += 3;
		else if (words[3].charAt(0) == 'c') // chicken
			key += 2;
		else // pizza
			key += 1;
		int[] data = { key, Integer.parseInt(words[4]) };
		return data;
	}
}
