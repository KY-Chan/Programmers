package programmers.level3.c43164;

import java.util.*;

// ���� ���
// bfs
public class Solution {
	public String[] solution(String[][] tickets) {
		// node : Map<�����, List<(������, Ƽ�� ��ȣ)>>
		Map<String, List<Info>> node = new HashMap<String, List<Info>>();
		
		// node �� Ƽ������ �Է�
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
		// ICN���� ����ϴ� Ƽ���� ��� que�� ����
		// new Ticket(Ž�� Ƚ��, �����, ������, ������ answer, �湮���)
		for (Info info : node.get("ICN"))
			que.add(new Ticket(1, "ICN", info.end, "ICN_" + info.end, visit(new boolean[10000], info.code)));
		int complete = tickets.length;
		PriorityQueue<String> answers = new PriorityQueue<String>();
		
		while (!que.isEmpty()) {
			Ticket ticket = que.poll();
			List<Info> curNode = node.get(ticket.end);
			// �ش� ���׿��� �ٸ� �������� ���ϴ� Ƽ�� ���� ����
			if (curNode != null) {
				for (Info info : curNode) {
					// �ش� Ƽ���� �̹� ���Ǿ�����
					if (!ticket.visited[info.code]) {
						// new Ticket(Ž�� Ƚ�� + 1, ���� ����, ������ ����, ������ answer, �湮���)
						que.add(new Ticket(ticket.count + 1, ticket.end, info.end, ticket.history + "_" + info.end,
								visit(ticket.visited, info.code)));
					}
				}
			}
			// ��� ��带 Ž�������� answer�� ���
			if(ticket.count == complete)
				answers.add(ticket.history);
		}
		// �������� ���� ���� ��
		String[] answer = answers.poll().split("_");
		return answer;

	}

	// �湮 ��� code��° index�� �߰��Ͽ� �Ѱ���
	public boolean[] visit(boolean[] visited, int code) {
		boolean[] newVisited = visited.clone();
		newVisited[code] = true;
		return newVisited;
	}

	// Map �� �ֱ� ���� ������ ����
	public class Info {
		public String end;
		public int code;

		public Info(String end, int code) {
			this.end = end;
			this.code = code;
		}
	}
	// Queue �� �ֱ� ���� Ƽ�� ����
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
