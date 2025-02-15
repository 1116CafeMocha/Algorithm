import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String A = br.readLine().strip();
		String B = br.readLine().strip();
		String C = br.readLine().strip();
		
		System.out.println(Integer.parseInt(A)+Integer.parseInt(B)-Integer.parseInt(C));
		System.out.println(Integer.parseInt(A+B)-Integer.parseInt(C));

	}

}