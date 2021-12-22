package skill3_329575;
//fail
public class Solution {
	public int solution(int sticker[]) {
		int max1 = sticker[0];
		int max2 = sticker[1];
		int sleep1 = 0;
		int sleep2 = 1;
		int pos = 2;
		while (pos < sticker.length - 1) {
			if (sleep1 == 0 && pos < sticker.length) {
				if(sticker[pos] > sticker[pos + 1]) {
					max1 += sticker[pos];
					sleep1 = 2;
				} else {
					max1 += sticker[pos + 1];
					sleep1 = 3;
				}
			}
			if (sleep2 == 0) {
				if(sticker[pos] > sticker[pos + 1]) {
					max2 += sticker[pos];
					sleep2 = 2;
				} else {
					max2 += sticker[pos + 1];
					sleep2 = 3;
				}
			}
			sleep1--;
			sleep2--;
			pos++;
		}
		if (sleep2 == 0) { // 마지막 부분 선택
			max2 += sticker[pos];
		}
		
		int answer = Math.max(max1, max2);
		return answer;
	}

}
