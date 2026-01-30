import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		BigInteger num = new BigInteger(br.readLine());
		
		if(N == 1) {
			bw.write(num.toString());
			bw.flush();
			return;
		}
		
		Deque<BigInteger> dq = new ArrayDeque<>();
		List<Character> list = new ArrayList<>();
		
		dq.add(num);
		
		for(int i=0; i<N-1; i++) {
			char C = br.readLine().charAt(0);
			BigInteger now = new BigInteger(br.readLine());
			
			if(C == '*' || C == '/') {
				BigInteger pre = dq.pollLast();
				dq.add(calculate(pre, now, C));
			} else {
				list.add(C);
				dq.add(now);
			}
		}
		
		BigInteger answer = dq.pollFirst();
		for(char now : list) {
			answer = calculate(answer, dq.pollFirst(), now);
		}
		
		bw.write(answer.toString());
		
		bw.flush();
		bw.close();
	}
	
	static BigInteger calculate (BigInteger A, BigInteger B, char C) {
		if(C == '*') return A.multiply(B);
		else if(C == '+') return A.add(B);
		else if(C == '-') return A.subtract(B);
		
		// 문제가 파이썬에 맞춘 문제인듯?? gpt로 해결 시도
		// floor division
	    BigInteger[] qr = A.divideAndRemainder(B); // qr[0]=quotient, qr[1]=remainder
	    BigInteger q = qr[0];
	    BigInteger r = qr[1];

	    // 나머지가 0이 아니고, 부호가 다르면(결과가 음수면) 몫을 1 감소
	    if (!r.equals(BigInteger.ZERO) && A.signum() != B.signum()) {
	        q = q.subtract(BigInteger.ONE);
	    }
	    return q;
	}
	
}
