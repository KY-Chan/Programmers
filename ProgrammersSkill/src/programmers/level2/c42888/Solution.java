package programmers.level2.c42888;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public String[] solution(String[] record) {
        Map<String, String> ID = new HashMap<String, String>();
        for(int idx = 0; idx < record.length; idx++) {
        	String[] records = record[idx].split(" ");
        	if(!records[0].equals("Leave")) {
        		ID.put(records[1], records[2]);
        	}
        }
        List<String> answers = new ArrayList<String>();
        for(int idx = 0; idx < record.length; idx++) {
        	String[] records = record[idx].split(" ");
        	if(records[0].equals("Enter")) {
        		answers.add(ID.get(records[1]) + "´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.");
        	} else if (records[0].equals("Leave")) {
        		answers.add(ID.get(records[1]) + "´ÔÀÌ ³ª°¬½À´Ï´Ù.");
        	}
        }
        
        return answers.toArray(new String[answers.size()]);
    }
}
