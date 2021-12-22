package programmers.level3.c42898;

public class Solution {
	public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        long[][] visited = new long[n][m];
        visited[0][0] = 1;
        for(int[] puddle : puddles) {
        	visited[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        for(int x = 0; x < n; x++) {
        	for(int y = 0; y < m; y++) {
        		if(visited[x][y] == -1) {
        			continue;
        		}
        		if(x < n - 1 && visited[x + 1][y] != -1) {
        			visited[x + 1][y] += visited[x][y];
        			visited[x + 1][y] %= 1000000007;
        		}
        		if(y < m - 1 && visited[x][y + 1] != -1) {
        			visited[x][y + 1] += visited[x][y];
        			visited[x][y + 1] %= 1000000007;
        		}
        	}
        }
        answer = (int) visited[n-1][m-1];
        return answer;
    }
}
