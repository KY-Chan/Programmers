package programmers.level4.c60060;

import java.util.HashMap;
import java.util.Map;
// ���� �˻�
public class Solution2 {
	public int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];
		Map<Integer, Trie> lyrics = new HashMap<Integer, Trie>();
		// �� �ܾ��� ���̸��� Trie ������ֱ�
		for (String word : words) {
			int length = word.length();
			if(!lyrics.containsKey(length))
				lyrics.put(length, new Trie());
			lyrics.get(length).insert(word);
		}

		for (int i = 0; i < answer.length; i++)
			if(lyrics.containsKey(queries[i].length()))
				answer[i] = lyrics.get(queries[i].length()).find(queries[i]);
		
		return answer;
	}

	public class Trie {
		Node forward;
		Node backward;

		public Trie() {
			this.forward = new Node();
			this.forward.val = ' ';
			this.backward = new Node();
			this.backward.val = ' ';
		}
		// ������, ������ ����
		public void insert(String str) {
			Node curFor = this.forward;
			for (int i = 0; i < str.length(); i++) {
				int f = str.charAt(i) - 'a';
				if (curFor.child[f] == null) {
					curFor.child[f] = new Node();
					curFor.child[f].val = str.charAt(i);
				}
				curFor.count++;
				curFor = curFor.child[f];
			}
			Node curBack = this.backward;
			for (int i = str.length() - 1; i >= 0; i--) {
				int b = str.charAt(i) - 'a';
				if (curBack.child[b] == null) {
					curBack.child[b] = new Node();
					curBack.child[b].val = str.charAt(i);
				}
				curBack.count++;
				curBack = curBack.child[b];
			}
		}
		// '?' ��ġ�� ���� ������, ������ Ž��
		public int find(String str) {
			if (str.charAt(0) != '?') {
				Node current = this.forward;
				for (int i = 0; i < str.length(); i++) {
					if (str.charAt(i) == '?')
						break;
					int f = str.charAt(i) - 'a';
					if (current.child[f] == null)
						return 0;
					current = current.child[f];
				}
				return current.count;
			} else {
				Node current = this.backward;
				for (int i = str.length() - 1; i >= 0; i--) {
					if (str.charAt(i) == '?')
						break;
					int b = str.charAt(i) - 'a';
					if (current.child[b] == null)
						return 0;
					current = current.child[b];
				}
				return current.count;
			}

		}
	}

	public class Node {
		Node[] child = new Node[26];
		int count = 0;
		char val;
	}
}
