import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
	int num;
	int cost;

	public Node(int num, int cost) {
		this.num = num;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
}

public class Main {
	static List<List<Node>> list;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		input = br.readLine().split(" ");
		int V = Integer.parseInt(input[0]);
		int E = Integer.parseInt(input[1]);
		int K = Integer.parseInt(br.readLine());

		list = new ArrayList<>();
		dist = new int[V + 1];

		for (int i = 0; i < V + 1; i++) {
			list.add(new ArrayList<>());
		}
		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 0; i < E; i++) {
			input = br.readLine().split(" ");
			int u = Integer.parseInt(input[0]);
			int v = Integer.parseInt(input[1]);
			int w = Integer.parseInt(input[2]);

			list.get(u).add(new Node(v, w));
		}

		dijkstra(K);

		for (int i = 1; i < V + 1; i++) {
			if (dist[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(dist[i]);
		}

	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.offer(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			int nowNum = now.num;
			int nowCost = now.cost;

			if (dist[nowNum] < nowCost)
				continue;

			for (Node next : list.get(nowNum)) {
				int newCost = dist[nowNum] + next.cost;

				if (newCost < dist[next.num]) {
					dist[next.num] = newCost;
					pq.offer(new Node(next.num, newCost));
				}
			}
		}
	}

}
