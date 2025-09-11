import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			long aa = Math.abs((long) a);
			long bb = Math.abs((long) b);

			if (aa != bb) {
				return Long.compare(aa, bb);
			}

			return Integer.compare(a, b);
		});

		while (N-- > 0) {
			int x = Integer.parseInt(br.readLine());

			if (x == 0) {
				if (pq.isEmpty()) {
					bw.write("0\n");
				} else {
					bw.write(Integer.toString(pq.poll()));
					bw.newLine();
				}
			} else {
				pq.add(x);
			}
		}

		bw.flush();
		bw.close();
	}
}
