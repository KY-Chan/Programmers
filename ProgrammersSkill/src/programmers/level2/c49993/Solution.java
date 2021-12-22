package programmers.level2.c49993;

import java.util.HashMap;
import java.util.Map;
// 스킬트리
public class Solution {
	public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(String skill_tree : skill_trees) {
            Map<Character, Integer> skillMap = new HashMap<Character, Integer>();
        	for(int i = 0; i < skill_tree.length(); i++) 
        		skillMap.put(skill_tree.charAt(i), i);
        	if(isValid(skill, skillMap))
        		answer++;
        }
        
        return answer;
    }
	public boolean isValid(String skill, Map<Character, Integer> skillMap) {
		int[] location = new int[skill.length()];
    	for(int i = 0; i < skill.length(); i++) 
    		location[i] = skillMap.getOrDefault(skill.charAt(i), 100);
    	// 스킬트리에 맞지 않을 때
    	for(int i = 0; i < location.length - 1; i++)
    		if(location[i] > location[i + 1]) 
    			return false;
		return true;
	}
}
