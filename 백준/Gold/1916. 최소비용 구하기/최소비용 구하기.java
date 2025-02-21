import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class City implements Comparable<City> {
	int cityNo, cost = 0;

	public City(int cityNo, int cost) {
		this.cityNo = cityNo;
		this.cost = cost;
	}

	// 비용이 적은 순으로 정렬
	@Override
	public int compareTo(City o) {
		return this.cost - o.cost;
	}
}

public class Main {
	// 인접 리스트
	static List<List<City>> graph;
	// 최소 비용 저장 배열
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;

		// N: 도시의 개수
		int N = Integer.parseInt(br.readLine().strip());
		// M: 버스의 개수
		int M = Integer.parseInt(br.readLine().strip());
		
		graph = new ArrayList<>();
		dist = new int[N+1];
		
		// dist 배열 최댓값으로 초기화
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		// 인접 리스트 초기화
		for(int i=0; i<N+1; i++) {
			graph.add(new ArrayList<>());
		}
		
		// 버스 정보 입력받아 그래프에 저장
		for(int i=0; i<M; i++) {
			input = br.readLine().split(" ");
			int departure = Integer.parseInt(input[0]);
			int destination = Integer.parseInt(input[1]);
			int cost = Integer.parseInt(input[2]);
			
			graph.get(departure).add(new City(destination, cost));
		}
		
		input = br.readLine().split(" ");
		int start = Integer.parseInt(input[0]);
		int end = Integer.parseInt(input[1]);
		
		dijkstra(start);
		
		System.out.println(dist[end]);
	}

	static void dijkstra(int start) {
		PriorityQueue<City> pq = new PriorityQueue<>();
		pq.offer(new City(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			City now = pq.poll();
			int nowCityNo = now.cityNo;
			int nowCost = now.cost;
			
			// 이미 처리된 노드라면 무시
			if(dist[nowCityNo] < nowCost) continue;
			
			// 현재 노드와 연결된 모든 노드 확인
			for(City next: graph.get(nowCityNo)) {
				int nextCityNo = next.cityNo;
				int nextCost = nowCost+next.cost;
				
				// 기존 비용보다 더 적은 비용으로 갈 수 있는 경우 갱신
				if(nextCost < dist[nextCityNo]) {
					dist[nextCityNo] = nextCost;
					// 우선순위 큐에 추가
					pq.offer(new City(nextCityNo, nextCost));
				}
			}
		}
	}

}