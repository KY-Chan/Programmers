package programmers.level3.c43162;
//네트워크
public class Solution {
    boolean[] visited;
	public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for(int idx = 0; idx < n; idx++) {
        	if(!visited[idx]) {
        		dfs(idx, computers);
        		answer++;
        	}
        }
        return answer;
    }
	public void dfs(int idx, int[][] computers) {
		visited[idx] = true;
		for(int computer = 0; computer < computers.length; computer++) {
			if(computers[idx][computer] == 1 && computer != idx && !visited[computer]) {
				dfs(computer, computers);
			}
		}
	}
}
