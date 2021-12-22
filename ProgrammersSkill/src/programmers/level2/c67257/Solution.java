package programmers.level2.c67257;

import java.util.ArrayList;
import java.util.List;
// 수식 최대화
public class Solution {
	public long solution(String expression) {
		long answer = 0;
		char[][] orders = { { '*', '+', '-' }, { '*', '-', '+' }, { '+', '*', '-' }, { '+', '-', '*' },
				{ '-', '*', '+' }, { '-', '+', '*' } };
		List<Double> nums = new ArrayList<Double>();
		for (String num : expression.split("[\\+\\-\\*]"))
			nums.add(Double.parseDouble(num));

		List<Character> ops = new ArrayList<Character>();
		for (char c : expression.replaceAll("[0-9]", "").toCharArray())
			ops.add(c);

		System.out.println(nums);
		System.out.println(ops);

		for (char[] order : orders) {
			List<Double> tNums = new ArrayList<Double>(nums);
			List<Character> tOps = new ArrayList<Character>(ops);

			for (char op : order) 
				for (int i = 0; i < tOps.size(); i++) 
					if(tOps.get(i) == op) 
						tNums.set(i, calculation(tNums.get(i), tNums.remove(i + 1), tOps.remove(i--)));
			answer = (long) Math.max(answer, Math.abs(tNums.get(0)));
		}
		return answer;
	}
	public double calculation(double a, double b, char op) {
		if(op == '+')
			return a + b;
		else if (op == '-')
			return a - b;
		else
			return a * b;
	}
}
