package programmers.level4.c62050;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
	public int solution(int[][] land, int height) {
		int answer = 0;
		int N = land.length;

		int[][] landInfo = new int[N][N];
		int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		
		Map<Integer, Map<Integer, Integer>> ladders = new HashMap<Integer, Map<Integer, Integer>>();
		int landIdx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 방문하지 않은 지형
				if (landInfo[i][j] == 0) {
					++landIdx;
					Map<Integer, Integer> ladder = new HashMap<Integer, Integer>();
					Queue<int[]> que = new LinkedList<int[]>();
					int[] startPos = { i, j };
					que.add(startPos);
					while (!que.isEmpty()) {
						int[] curPos = que.poll();
						int y = curPos[0];
						int x = curPos[1];
						// 지형 구분값 저장
						landInfo[y][x] = landIdx;
						// 오른쪽
						for (int[] d : direction) {
							int nextX = x + d[1];
							int nextY = y + d[0];
							if (nextX < N && nextY < N && nextX >= 0 && nextY >= 0) {
								if (landInfo[nextY][nextX] == 0) {
									int gap = Math.abs(land[nextY][nextX] - land[y][x]);
									if (gap <= height) {
										landInfo[nextY][nextX] = landIdx;
										int[] nextPos = { nextY, nextX };
										que.add(nextPos);
									}
								} else {
									int gap = Math.abs(land[nextY][nextX] - land[y][x]);
									if (gap > height) {
										ladder.merge(landInfo[nextY][nextX], gap, (oldW, newW) -> Math.min(oldW, newW));
									}
								}
							}
						}
					}
					ladders.put(landIdx, ladder); // 정방향
					for (int key : ladder.keySet()) { // 역방향
						ladders.get(key).put(landIdx, ladder.get(key));
					}
				}
			}
		}

		// 프림 알고리즘
		boolean[] visited = new boolean[landIdx + 1];
		int[] distance = new int[landIdx + 1];
		Arrays.fill(distance, 10001);
		distance[1] = 0;
		
		PriorityQueue<int[]> que = new PriorityQueue<int[]>((o1, o2) -> o1[1] - o2[1]);
		int[] firstNode = {1, 0};
		que.add(firstNode);
		int count = 0;
		while(true) {
			int[] cur = que.poll();
			
			if(visited[cur[0]]) {
				continue;
			}
			visited[cur[0]] = true;
			answer += cur[1];
			count++;
			
			if(count == landIdx) {
				break;
			}
			Map<Integer, Integer> curMap = ladders.get(cur[0]);
			for(int key : curMap.keySet()) {
				if(!visited[key] && distance[key] > curMap.get(key)) {
					distance[key] = curMap.get(key);
					int[] nextNode = {key, curMap.get(key)};
					que.add(nextNode);
				}
			}
		}
		return answer;
	}

	public List<Integer> newLadder(int y, int x, int dy, int dx) {
		List<Integer> ladder = new ArrayList<Integer>();
		// 오른쪽
		ladder.add(y);
		ladder.add(x);
		ladder.add(y + dy);
		ladder.add(x + dx);
		return ladder;
	}
	
	/*
	 * public int solution3(int[][] land, int height) { int answer = 0; int N =
	 * land.length;
	 * 
	 * int[][] landInfo = new int[N][N]; int[][] direction = { { 0, 1 }, { 1, 0 }, {
	 * 0, -1 }, { -1, 0 } }; Set<List<Integer>> ladders = new
	 * HashSet<List<Integer>>(); int landIdx = 0; for (int i = 0; i < N; i++) { for
	 * (int j = 0; j < N; j++) { // 방문하지 않은 지형 if (landInfo[i][j] == 0) { ++landIdx;
	 * Queue<int[]> que = new LinkedList<int[]>(); int[] startPos = { i, j };
	 * que.add(startPos); while (!que.isEmpty()) { int[] curPos = que.poll(); int y
	 * = curPos[0]; int x = curPos[1]; // 지형 구분값 저장 landInfo[y][x] = landIdx; // 오른쪽
	 * for(int[] d : direction) { if(x + d[1] < N && y + d[0] < N && x + d[1]>= 0 &&
	 * y + d[0] >= 0) { if (landInfo[y + d[0]][x + d[1]] == 0) { if (Math.abs(land[y
	 * + d[0]][x + d[1]] - land[y][x]) <= height) { landInfo[y + d[0]][x + d[1]] =
	 * landIdx; int[] nextPos = { y + d[0], x + d[1] }; que.add(nextPos); } else {
	 * ladders.add(newLadder(y, x, d[0], d[1])); } } } } // if (x + 1 < N) { // if
	 * (landInfo[y][x + 1] == 0) { // if (Math.abs(land[y][x + 1] - land[y][x]) <=
	 * height) { // landInfo[y][x + 1] = landIdx; // int[] nextPos = { y, x + 1 };
	 * // que.add(nextPos); // } else { // ladders.add(newLadder(y, x, 0, 1)); // }
	 * // } // } // // 아래쪽 // if (y + 1 < N) { // if (landInfo[y + 1][x] == 0) { //
	 * if (Math.abs(land[y + 1][x] - land[y][x]) <= height) { // landInfo[y + 1][x]
	 * = landIdx; // int[] nextPos = { y + 1, x }; // que.add(nextPos); // } else {
	 * // ladders.add(newLadder(y, x, 1, 0)); // } // } // } // // 왼쪽 // if (x > 0)
	 * { // if (landInfo[y][x - 1] == 0) { // if (Math.abs(land[y][x - 1] -
	 * land[y][x]) <= height) { // landInfo[y][x - 1] = landIdx; // int[] nextPos =
	 * { y, x - 1 }; // que.add(nextPos); // } else { // ladders.add(newLadder(y, x,
	 * 0, -1)); // } // } // } // // 위쪽 // if (y > 0) { // if (landInfo[y - 1][x] ==
	 * 0) { // if (Math.abs(land[y - 1][x] - land[y][x]) <= height) { // landInfo[y
	 * - 1][x] = landIdx; // int[] nextPos = { y - 1, x }; // que.add(nextPos); // }
	 * else { // ladders.add(newLadder(y, x, -1, 0)); // } // } // } } } } }
	 * 
	 * Map<Integer, Integer> landNode = new HashMap<Integer, Integer>(); for
	 * (List<Integer> ladder : ladders) { int y1 = ladder.get(0); int x1 =
	 * ladder.get(1); int y2 = ladder.get(2); int x2 = ladder.get(3); if
	 * (landInfo[y1][x1] == landInfo[y2][x2]) { continue; } int weight =
	 * Math.abs(land[y1][x1] - land[y2][x2]); landNode.merge(landInfo[y1][x1],
	 * weight, (oldW, newW) -> Math.min(oldW, newW));
	 * landNode.merge(landInfo[y2][x2], weight, (oldW, newW) -> Math.min(oldW,
	 * newW)); } for (int key : landNode.keySet()) { if (key != 1) { answer +=
	 * landNode.get(key); } } System.out.println(landNode); return answer; }
	 * 
	 * 
	 * public int solution4(int[][] land, int height) { int answer = 0; int N =
	 * land.length;
	 * 
	 * int[][] landInfo = new int[N][N]; int[][] direction = { { 0, 1 }, { 1, 0 }, {
	 * 0, -1 }, { -1, 0 } }; List<Map<Integer, Integer>> ladders = new
	 * ArrayList<Map<Integer, Integer>>(); int landIdx = 0; for (int i = 0; i < N;
	 * i++) { for (int j = 0; j < N; j++) { // 방문하지 않은 지형 if (landInfo[i][j] == 0) {
	 * ++landIdx; Map<Integer,Integer> ladder = new HashMap<Integer,Integer>();
	 * Queue<int[]> que = new LinkedList<int[]>(); int[] startPos = { i, j };
	 * que.add(startPos); while (!que.isEmpty()) { int[] curPos = que.poll(); int y
	 * = curPos[0]; int x = curPos[1]; // 지형 구분값 저장 landInfo[y][x] = landIdx; // 오른쪽
	 * for(int[] d : direction) { int nextX = x + d[1]; int nextY = y + d[0];
	 * if(nextX < N && nextY < N && nextX>= 0 && nextY >= 0) { if
	 * (landInfo[nextY][nextX] == 0) { if (Math.abs(land[nextY][nextX] - land[y][x])
	 * <= height) { landInfo[nextY][nextX] = landIdx; int[] nextPos = { nextY, nextX
	 * }; que.add(nextPos); } } else { if (Math.abs(land[nextY][nextX] - land[y][x])
	 * > height) { ladder.merge(landIdx, landInfo[nextY][nextX], (oldW, newW) ->
	 * Math.min(oldW, newW)); } } } }
	 * 
	 * } } } }
	 * 
	 * List<Map<Integer, Integer>> nodeList = new ArrayList<Map<Integer,
	 * Integer>>(); for (int i = 0; i < landIdx + 1; i++) { nodeList.add(new
	 * HashMap<Integer, Integer>()); } for(int i =0 ; i< N; i++) {
	 * System.out.println(Arrays.toString(landInfo[i])); }
	 * System.out.println(ladders); for (Map<Integer, Integer> ladder : ladders) {
	 * int y1 = ladder.get(0); int x1 = ladder.get(1); int y2 = ladder.get(2); int
	 * x2 = ladder.get(3); int start = landInfo[y1][x1]; int end = landInfo[y2][x2];
	 * if (start == end) { continue; } int weight = Math.abs(land[y1][x1] -
	 * land[y2][x2]); nodeList.get(start).merge(end, weight, (oldW, newW) ->
	 * Math.min(oldW, newW)); } for (int i = 1; i < landIdx; i++) { if
	 * (!nodeList.get(i).isEmpty()) { nodeList.get(i).forEach( (key, value) ->
	 * nodeList.get(0).merge(key, value, (oldW, newW) -> Math.min(oldW, newW))); }
	 * Optional<Entry<Integer, Integer>> entry = nodeList.get(0).entrySet().stream()
	 * .min((o1, o2) -> o1.getValue() - o2.getValue()); answer +=
	 * entry.get().getValue(); nodeList.get(0).remove(entry.get().getKey()); }
	 * return answer; }
	 */
}
