import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static class reg {
		int number = 0;
		String func = "";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().strip());
		String[] input;
		int A, B = 0;
		Queue<reg> que = new LinkedList<>();

		for (int testcase = 0; testcase < T; testcase++) {
			que.clear();
			input = br.readLine().split(" ");
			A = Integer.parseInt(input[0]);
			B = Integer.parseInt(input[1]);

			boolean[] visited = new boolean[10000];

			reg start = new reg();
			start.number = A;
			que.add(start);
			visited[A] = true;

			loop: while (true) {
				if (que.isEmpty()) {
					break;
				}
				int size = que.size();

				for (int i = 0; i < size; i++) {
					reg REG = que.poll();

					reg tempD = new reg();
					tempD.number = funcD(REG.number);
					tempD.func = REG.func + "D";

					if (!visited[tempD.number]) {
						visited[tempD.number] = true;
						que.add(tempD);
					}

					if (tempD.number == B) {
						System.out.println(tempD.func);
						break loop;
					}

					reg tempS = new reg();
					tempS.number = funcS(REG.number);
					tempS.func = REG.func + "S";

					if (!visited[tempS.number]) {
						visited[tempS.number] = true;
						que.add(tempS);
					}

					if (tempS.number == B) {
						System.out.println(tempS.func);
						break loop;
					}

					reg tempL = new reg();
					tempL.number = funcL(REG.number);
					tempL.func = REG.func + "L";

					if (!visited[tempL.number]) {
						visited[tempL.number] = true;
						que.add(tempL);
					}

					if (tempL.number == B) {
						System.out.println(tempL.func);
						break loop;
					}

					reg tempR = new reg();
					tempR.number = funcR(REG.number);
					tempR.func = REG.func + "R";

					if (!visited[tempR.number]) {
						visited[tempR.number] = true;
						que.add(tempR);
					}

					if (tempR.number == B) {
						System.out.println(tempR.func);
						break loop;
					}
				}
			}
		}
	}

	static int funcD(int N) {
		return (N * 2) % 10000;
	}

	static int funcS(int N) {
		if (N == 0)
			return 9999;
		else
			return N - 1;
	}

	static int funcL(int N) {
		return (N % 1000 / 100) * 1000 + (N % 100 / 10) * 100 + (N % 10) * 10 + (N / 1000);
	}

	static int funcR(int N) {
		return (N % 10) * 1000 + (N / 1000) * 100 + (N % 1000 / 100) * 10 + (N % 100 / 10);
	}

}
