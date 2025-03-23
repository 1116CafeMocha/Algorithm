// 백준 2042번. 구간 합 구하기

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	static class SegmentTree {
		long[] tree;
		int size;

		SegmentTree(long[] arr) {
			size = arr.length;
			tree = new long[size * 4];
			build(arr, 1, 0, size - 1);
		}

		void build(long[] arr, int node, int start, int end) {
			if (start == end) {
				tree[node] = arr[start];
			} else {
				int mid = (start + end) / 2;
				build(arr, node * 2, start, mid);
				build(arr, node * 2 + 1, mid + 1, end);
				tree[node] = tree[node * 2] + tree[node * 2 + 1];
			}
		}

		long sum(int node, int start, int end, int left, int right) {
			if (right < start || end < left)
				return 0;
			if (left <= start && end <= right)
				return tree[node];

			int mid = (start + end) / 2;
			return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
		}

		void update(int node, int start, int end, int idx, long val) {
			if (idx < start || idx > end)
				return;

			if (start == end) {
				tree[node] = val;
			} else {
				int mid = (start + end) / 2;
				update(node * 2, start, mid, idx, val);
				update(node * 2 + 1, mid + 1, end, idx, val);
				tree[node] = tree[node * 2] + tree[node * 2 + 1];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] input;

		input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int K = Integer.parseInt(input[2]);

		long[] nums = new long[N];

		for (int i = 0; i < N; i++) {
			nums[i] = Long.parseLong(br.readLine());
		}

		SegmentTree seg = new SegmentTree(nums);

		for (int i = 0; i < M + K; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			long b = Long.parseLong(input[1]) - 1;
			long c = Long.parseLong(input[2]);

			if (a == 1) {
				seg.update(1, 0, N - 1, (int) b, c);
			} else if (a == 2) {
				int right = (int) c - 1;
				bw.write(Long.toString(seg.sum(1, 0, N - 1, (int) b, right)) + "\n");
			}
		}

		bw.flush();
		bw.close();
	}

}
