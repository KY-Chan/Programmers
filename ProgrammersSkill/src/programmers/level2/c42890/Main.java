package programmers.level2.c42890;


public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String[][] relation = {{"100","ryan","music","2"}, 
							   {"200","apeach","math","2"},
							   {"300","tube","computer","3"},
							   {"400","con","computer","4"},
							   {"500","muzi","music","3"},
							   {"600","apeach","music","2"}};
		System.out.println(sol.solution(relation));
	}
	
}
