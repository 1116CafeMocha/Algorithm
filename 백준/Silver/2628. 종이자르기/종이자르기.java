import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int C = Integer.parseInt(br.readLine());

		List<Integer> listW = new ArrayList<>();
		List<Integer> listH = new ArrayList<>();
		
		listW.add(0);
		listH.add(0);
		listW.add(W);
		listH.add(H);

		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			int point = Integer.parseInt(st.nextToken());

			if (order == 0)
				listH.add(point);
			else
				listW.add(point);
		}

		Collections.sort(listW);
		Collections.sort(listH);

		int maxW = 0, maxH = 0;

		for (int i = 1; i < listW.size(); i++) 
			maxW = Math.max(maxW, listW.get(i) - listW.get(i-1));

		for (int i = 1; i < listH.size(); i++) 
			maxH = Math.max(maxH, listH.get(i) - listH.get(i-1));
		
		bw.write(Integer.toString(maxW * maxH));

		bw.flush();
		bw.close();
	}

}