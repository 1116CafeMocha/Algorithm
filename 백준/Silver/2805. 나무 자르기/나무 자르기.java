import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int maxTree = 0;

		st = new StringTokenizer(br.readLine());
		int[] trees = new int[N];
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			maxTree = Math.max(maxTree, trees[i]);
		}

		int left = 0;
		int right = maxTree;
		int MAX = 0;

		while (left <= right) {
			long sum = 0;
			int mid = left + (right - left) / 2;

			for (int tree : trees)
				sum += tree > mid ? tree - mid : 0;

			if (sum >= M) {
				MAX = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		bw.write(Integer.toString(MAX));
		bw.flush();
		bw.close();
		br.close();
    }
}