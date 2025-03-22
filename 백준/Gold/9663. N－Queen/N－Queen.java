import java.util.Scanner;

// 백준 9663번. N-Queen

public class Main {
	static int N;
	static int count = 0;
	static boolean[] col, diagonalL, diagonalR;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		col = new boolean[N];
		diagonalL = new boolean[2*N];
		diagonalR = new boolean[2*N];
		
		backtrack(0);
		System.out.println(count);

	}
	
	static void backtrack(int row) {
		if(row == N) {
			count++;
			return;
		}
		
		for(int c=0; c<N; c++) {
			if(col[c]) continue;
			if(diagonalL[row+c]) continue;
			if(diagonalR[row-c+(N-1)]) continue;
			
			diagonalL[row+c] = true;
			diagonalR[row-c+(N-1)] = true;
			col[c] = true;
			
			backtrack(row+1);
			
			diagonalL[row+c] = false;
			diagonalR[row-c+(N-1)] = false;
			col[c] = false;
		}
	}

}
