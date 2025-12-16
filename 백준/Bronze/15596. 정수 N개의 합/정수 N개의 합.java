public class Test {
	
	public static long sum (int[] a) {
		long answer = 0;
		for(int now : a) {
			answer += now;
		}
		return answer;
	}

}
