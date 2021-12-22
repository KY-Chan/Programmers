package programmers.level3.c64064;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	Set<HashSet<Integer>> banList = new HashSet<HashSet<Integer>>();
	public int solution(String[] user_id, String[] banned_id) {
		int answer = 0;
		List<ArrayList<Integer>> bannedList = rawList(user_id, banned_id);

		HashSet<Integer> ban = new HashSet<Integer>();
		dfs(bannedList, ban, 0);
		answer = banList.size();
		return answer;
	}

	public boolean filtering(String id, String filter) {
		if (id.length() != filter.length()) {
			return false;
		}
		char[] idChr = id.toCharArray();
		char[] ftChr = filter.toCharArray();
		for (int pos = 0; pos < idChr.length; pos++) {
			if (ftChr[pos] != '*') {
				if (idChr[pos] != ftChr[pos]) {
					return false;
				}
			}
		}
		return true;
	}

	public List<ArrayList<Integer>> rawList(String[] user_id, String[] banned_id) {
		List<ArrayList<Integer>> rawList = new ArrayList<ArrayList<Integer>>();
		for (String ban : banned_id) {
			ArrayList<Integer> oneList = new ArrayList<Integer>();
			for (int idx = 0; idx < user_id.length; idx++) {
				if (filtering(user_id[idx], ban)) {
					oneList.add(idx);
				}
			}
			if (!oneList.isEmpty()) {
				rawList.add(oneList);
			}
		}
		return rawList;
	}

	public void dfs(List<ArrayList<Integer>> rawList, HashSet<Integer> ban, int depth) {
		if(depth < rawList.size()) {
			for(int idx = 0; idx< rawList.get(depth).size(); idx++) {
				boolean added = ban.add(rawList.get(depth).get(idx));
				dfs(rawList, ban, depth + 1);
				if(added) {
					ban.remove(rawList.get(depth).get(idx));
				}
			}
		}
		else if(depth == ban.size()){
			HashSet<Integer> newBan = new HashSet<Integer>(ban);
			banList.add(newBan);
		}
	}
}
