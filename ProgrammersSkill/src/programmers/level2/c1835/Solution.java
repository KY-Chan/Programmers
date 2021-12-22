package programmers.level2.c1835;

import java.util.ArrayList;
import java.util.List;
// 단체사진 찍기
public class Solution {
	public int solution(int n, String[] data) {
        int answer = 0;
        List<String> all = kakao();
        for(int stage = 0; stage < data.length; stage++) {
        	char[] str = data[stage].toCharArray();
        	char condition = str[3];
        	int num = str[4] - '0';
        	int idx = 0;
        	while(idx < all.size()) {
        		
        		String check = all.get(idx);
        		int target1 = check.indexOf(str[0]);
        		int target2 = check.indexOf(str[2]);
        		int distance = Math.abs(target2 - target1) - 1;
        		if(condition == '=') {
        			if(distance != num) {
        				all.remove(idx);
        				continue;
        			} 
        		} else if (condition == '<') {
        			if(distance >= num) {
        				all.remove(idx);
        				continue;
        			}
        		} else {
        			if(distance <= num) {
        				all.remove(idx);
        				continue;
        			}
        		}
        		idx++;
        	}
        }
        answer = all.size();
        return answer;
    }

	public List<String> kakao() {
        String[] c = {"A", "C", "F", "J", "M", "N", "R", "T"};
        boolean[] b = new boolean[8];
		List<String> kakao = new ArrayList<String>();
		for(int a0 = 0; a0 < 8; a0++) {
			b[a0] = true;
			for(int a1 = 0; a1 < 8; a1++) {
				if(b[a1])
					continue;
				b[a1] = true;
				for(int a2 = 0; a2 < 8; a2++) {
					if(b[a2])
						continue;
					b[a2] = true;
					for(int a3 = 0; a3 < 8; a3++) {
						if(b[a3])
							continue;
						b[a3] = true;
						for(int a4 = 0; a4 < 8; a4++) {
							if(b[a4])
								continue;
							b[a4] = true;
							for(int a5 = 0; a5 < 8; a5++) {
								if(b[a5])
									continue;
								b[a5] = true;
								for(int a6 = 0; a6 < 8; a6++) {
									if(b[a6])
										continue;
									b[a6] = true;
									for(int a7 = 0; a7 < 8; a7++) {
										if(b[a7])
											continue;
										b[a7] = true;
										String asdf = c[0] + c[1];
										kakao.add(c[a0] + c[a1] + c[a2] + c[a3] + c[a4] + c[a5] + c[a6] + c[a7]);
										b[a7] = false;
									}
									b[a6] = false;
								}
								b[a5] = false;
							}
							b[a4] = false;
						}
						b[a3] = false;
					}
					b[a2] = false;
				}
				b[a1] = false;
			}
			b[a0] = false;
		}
		return kakao;
	}
}
