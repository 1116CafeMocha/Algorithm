import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
	
	public class Main {
		
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			int N = Integer.parseInt(br.readLine());
			
			Set<Integer> set = new HashSet<>();
			
			while(N-- > 0) {
				int G = Integer.parseInt(br.readLine());
				
				int[] arr = new int[G];
				
				for(int i=0; i<G; i++) {
					arr[i] = Integer.parseInt(br.readLine());
				}
				
				int i = 0;
				
				A : while(true) {
					set.clear();
					i++;
					for(int j=0; j<G; j++) {
						int now = arr[j] % i;
						
						if(set.contains(now)) {
							continue A;
						}
						set.add(now);
					}
					
					bw.write(Integer.toString(i));
					bw.newLine();
					break;
				}
			}
			
			bw.flush();
			bw.close();
		}
		
	}
