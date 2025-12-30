	import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
	
	public class Main {
		static class Lesson {
			int num;
			int start;
			int end;
			
			Lesson(int num, int start, int end){
				this.num = num;
				this.start = start;
				this.end = end;
			}
		}
		
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int N = Integer.parseInt(br.readLine());
			
			Lesson[] arr = new Lesson[N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				arr[i] = new Lesson(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(arr, (a, b) -> {
				if(a.start != b.start) return a.start - b.start;
				
				return a.end - b.end;
			});
			
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			
			for(Lesson now : arr) {
				if(!pq.isEmpty() && pq.peek() <= now.start) {
					pq.poll();
				}
				pq.offer(now.end);
			}
			
			bw.write(Integer.toString(pq.size()));
			
			bw.flush();
			bw.close();
		}
		
	}
