import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input;
		
		int T = Integer.parseInt(br.readLine().strip());
		
		for(int testcase=0; testcase<T; testcase++) {
			int N = Integer.parseInt(br.readLine().strip());
			
			HashMap<String, Integer> map = new HashMap<>();
			
			for(int i=0; i<N; i++) {
				input = br.readLine().split(" ");
				String name = input[0];
				String type = input[1];
				
				// 기존에 있던 종류면 +1, 없으면 새로 추가
				map.put(type, map.getOrDefault(type, 0) + 1);
			}
			
			// 조합 개수 계산
			// (각 종류별 개수 + 입지 않을 경우) 곱 - 모두 입지 않을 경우
			int answer = 1;
			for(int nums : map.values()) {
				answer *= (nums + 1);
			}
			answer -= 1;
			
			System.out.println(answer);
		}
	}

}
