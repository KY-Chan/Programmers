package programmers.level3.c43164;

import java.util.*;

// 여행 경로
// bfs
public class Solution {
	public String[] solution(String[][] tickets) {
		// node : Map<출발점, List<(도착점, 티켓 번호)>>
		Map<String, List<Info>> node = new HashMap<String, List<Info>>();
		
		// node 에 티켓정보 입력
		for (int i = 0; i < tickets.length; i++) {
			if (node.containsKey(tickets[i][0]))
				node.get(tickets[i][0]).add(new Info(tickets[i][1], i));
			else {
				List<Info> n = new ArrayList<Info>();
				n.add(new Info(tickets[i][1], i));
				node.put(tickets[i][0], n);
			}
		}
		
		// bfs
		Queue<Ticket> que = new LinkedList<Ticket>();
		// ICN에서 출발하는 티켓을 모두 que에 저장
		// new Ticket(탐색 횟수, 출발점, 도착점, 생성된 answer, 방문기록)
		for (Info info : node.get("ICN"))
			que.add(new Ticket(1, "ICN", info.end, "ICN_" + info.end, visit(new boolean[10000], info.code)));
		int complete = tickets.length;
		PriorityQueue<String> answers = new PriorityQueue<String>();
		
		while (!que.isEmpty()) {
			Ticket ticket = que.poll();
			List<Info> curNode = node.get(ticket.end);
			// 해당 공항에서 다른 공항으로 향하는 티켓 존재 여부
			if (curNode != null) {
				for (Info info : curNode) {
					// 해당 티켓이 이미 사용되었는지
					if (!ticket.visited[info.code]) {
						// new Ticket(탐색 횟수 + 1, 현재 공항, 목적지 공항, 생성된 answer, 방문기록)
						que.add(new Ticket(ticket.count + 1, ticket.end, info.end, ticket.history + "_" + info.end,
								visit(ticket.visited, info.code)));
					}
				}
			}
			// 모든 노드를 탐색했으면 answer에 담기
			if(ticket.count == complete)
				answers.add(ticket.history);
		}
		// 오름차순 가장 작은 값
		String[] answer = answers.poll().split("_");
		return answer;

	}

	// 방문 기록 code번째 index를 추가하여 넘겨줌
	public boolean[] visit(boolean[] visited, int code) {
		boolean[] newVisited = visited.clone();
		newVisited[code] = true;
		return newVisited;
	}

	// Map 에 넣기 위한 목적지 정보
	public class Info {
		public String end;
		public int code;

		public Info(String end, int code) {
			this.end = end;
			this.code = code;
		}
	}
	// Queue 에 넣기 위한 티켓 정보
	public class Ticket {
		public int count;
		public String start;
		public String end;
		public String history;
		public boolean[] visited;

		public Ticket(int count, String start, String end, String history, boolean[] visited) {
			this.count = count;
			this.start = start;
			this.end = end;
			this.history = history;
			this.visited = visited;
		}
	}
}
