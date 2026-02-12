import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String month = st.nextToken();
		int day = Integer.parseInt(st.nextToken().replace(",", ""));
		int year = Integer.parseInt(st.nextToken());
		String[] time = st.nextToken().split(":");
		int hour = Integer.parseInt(time[0]);
		int minute = Integer.parseInt(time[1]);
		
		Map<String, Integer> monthMap = new HashMap<>();
        monthMap.put("January", 1);
        monthMap.put("February", 2);
        monthMap.put("March", 3);
        monthMap.put("April", 4);
        monthMap.put("May", 5);
        monthMap.put("June", 6);
        monthMap.put("July", 7);
        monthMap.put("August", 8);
        monthMap.put("September", 9);
        monthMap.put("October", 10);
        monthMap.put("November", 11);
        monthMap.put("December", 12);
		
        int m = monthMap.get(month);

        boolean leap = yoon(year);
        int[] daysInMonth = leap
                ? new int[]{31,29,31,30,31,30,31,31,30,31,30,31}
                : new int[]{31,28,31,30,31,30,31,31,30,31,30,31};

        int daysBefore = 0;
        for (int i = 0; i < m - 1; i++) daysBefore += daysInMonth[i];

        long elapsedMinutes = 0;
        elapsedMinutes += (long)(daysBefore + (day - 1)) * 24 * 60;
        elapsedMinutes += (long)hour * 60 + minute;

        long totalMinutes = (long)(leap ? 366 : 365) * 24 * 60;

        double percent = elapsedMinutes * 100.0 / totalMinutes;

        bw.write(String.format("%.10f%n", percent));
		
		bw.flush();
		bw.close();
	}
	
	// 윤년 확인
	static boolean yoon(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }
}