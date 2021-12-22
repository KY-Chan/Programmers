package programmers.level1.c67256;
// 키패드 누르기
public class Solution {
	public String solution(int[] numbers, String hand) {
		String answer = "";
		int[] leftHand = { 3, 0 };
		int[] rightHand = { 3, 2 };
		for (int number : numbers) {
			switch (number) {
			case 1:
			case 4:
			case 7:
				answer += "L";
				leftHand[0] = (number - 1) / 3;
				leftHand[1] = 0;
				break;
			case 3:
			case 6:
			case 9:
				answer += "R";
				rightHand[0] = (number - 1) / 3;
				rightHand[1] = 2;
				break;
			case 0:
				number = 11;
			case 2:
			case 5:
			case 8:
				if (distance(leftHand, number) < distance(rightHand, number)) {
					answer += "L";
					leftHand[0] = (number - 1) / 3;
					leftHand[1] = (number - 1) % 3;
					break;
				} else if (distance(leftHand, number) > distance(rightHand, number)) {
					answer += "R";
					rightHand[0] = (number - 1) / 3;
					rightHand[1] = (number - 1) % 3;
					break;
				} else {
					if (hand.equals("left")) {
						answer += "L";
						leftHand[0] = (number - 1) / 3;
						leftHand[1] = (number - 1) % 3;
						break;
					} else {
						answer += "R";
						rightHand[0] = (number - 1) / 3;
						rightHand[1] = (number - 1) % 3;
						break;
					}

				}
			}
		}
		return answer;
	}

	public int distance(int[] hand, int number) {
		return Math.abs(hand[0] - (number - 1) / 3) + Math.abs(hand[1] - (number - 1) % 3);
	}
	
	public void moveHand(int[] hand, int number) { 
		hand[0] = (number - 1) / 3;
		hand[1] = (number - 1) % 3;
	}
}
