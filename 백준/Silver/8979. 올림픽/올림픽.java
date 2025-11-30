import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Country {
		int num;
		int gold;
		int silver;
		int bronze;

		Country(int num, int gold, int silver, int bronze) {
			this.num = num;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Country[] countries = new Country[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			countries[i] = new Country(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(countries, (a, b) -> {
			if (a.gold != b.gold)
				return b.gold - a.gold;
			if (a.silver != b.silver)
				return b.silver - a.silver;
			return b.bronze - a.bronze;
		});

		int idx = 1;

		for (int i = 0; i < N; i++) {
			if (i > 0) {
				Country prev = countries[i - 1];
				Country now = countries[i];

				if (now.gold != prev.gold || now.silver != prev.silver || now.bronze != prev.bronze) {
					idx = i + 1;
				}
			}

			if (countries[i].num == K) {
				bw.write(Integer.toString(idx));
				break;
			}
		}

		bw.flush();
		bw.close();
	}

}
