package programmers.level2.c17679;

public class Solution {
	public int solution(int m, int n, String[] board) {
		int remains = 0;
		// 시계방향으로 회전해서 생각
		String[] sb = new String[n];
		for(int i = 0 ; i < n; i++)
			sb[i] = new String("");

		for (int i = m - 1; i >= 0; i--) 
			for (int j = 0; j < n; j++)
				sb[j] += board[i].charAt(j);
		// 제거할 블록이 없을 때까지 반복
		while (true) {
			boolean next = false;
			// 계산을 위한 복사본
			char[][] cb = new char[n][];
			for(int i =0; i < n; i++)
				cb[i] = sb[i].toCharArray();
			// 제거 가능한 블록을 원본에서 발견 후 사본에서 제거
			for (int i = 0; i < n - 1; i++) {
				int max = Math.min(sb[i].length(), sb[i + 1].length()) - 1;
				for (int j = 0; j < max; j++) {
					if (isEqual(sb[i], sb[i + 1], j)) {
						cb[i][j] = cb[i][j + 1] = cb[i + 1][j] = cb[i + 1][j + 1] = '0';
						next = true;
					}
				}
			}
			// 사본의 내용을 원본에 다시 적용
			for(int i = 0 ; i < n; i++) {
				sb[i] = "";
				for(int j =0 ; j < cb[i].length; j++) 
					if (cb[i][j] != '0')
						sb[i] += cb[i][j];
			}
			if(!next)
				break;
		}
		
		for(int i = 0; i < n; i++) 
			remains += sb[i].length();
		
		int answer = m * n - remains;
		return answer;
	}

	public boolean isEqual(String ab, String cd, int j) {
		char a = ab.charAt(j);
		char b = ab.charAt(j + 1);
		char c = cd.charAt(j);
		char d = cd.charAt(j + 1);
		if (a == b && a == c && a == d)
			return true;
		else
			return false;
	}
}
