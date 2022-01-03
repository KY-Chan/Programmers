package programmers.level3.c72414;

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String play_time = "02:03:55";
		String adv_time = "00:14:15";
		String[] logs = { "01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29",
				"01:37:44-02:02:30" };
		System.out.println(sol.solution(play_time, adv_time, logs));
	}

}
