package programmers.level1.c64061;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
// 크레인 인형뽑기
public class Solution {
	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		int N = board.length;
		List<Queue<Integer>> boardList = makeListQueue(board);
		
		Stack<Integer> trashcan = new Stack<Integer>();
		
		for(int move : moves) {
			if(boardList.get(move - 1).isEmpty()) {
				continue;
			}
			int buddy = boardList.get(move - 1).poll();
			if(!trashcan.isEmpty()) {
				if(trashcan.peek() == buddy) {
					trashcan.pop();
					answer += 2;
				} else {
					trashcan.add(buddy);
				}
			} else {
				trashcan.add(buddy);
			}
		}
		return answer;
	}
	
	public List<Queue<Integer>> makeListQueue(int[][] board) {
		int N = board.length;
		List<Queue<Integer>> boardList = new ArrayList<Queue<Integer>>();
		for (int i = 0; i < N; i++) {
			Queue<Integer> boardQueue = new LinkedList<Integer>();
			for (int j = 0; j < N; j++) {
				if(board[j][i] > 0) {
					boardQueue.add(board[j][i]);
				}
			}
			boardList.add(boardQueue);
		}
		return boardList;
	}
}
