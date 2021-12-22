package programmers.level1.c42748;

import java.util.Arrays;

public class Solution {
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int cmd = 0; cmd < commands.length; cmd++) {
            int[] part = new int[commands[cmd][1] - commands[cmd][0] + 1];
            for(int i = 0; i < part.length; i++)
                part[i] = array[i + commands[cmd][0] - 1];
            Arrays.sort(part);
            answer[cmd] = part[commands[cmd][2]];
        }
        return answer;
    }
}
