import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] first = br.readLine().split(" ");
		int N = Integer.parseInt(first[0]);
		int M = Integer.parseInt(first[1]);

		Map<String, Set<String>> groupToMembers = new HashMap<>();
		Map<String, String> memberToGroup = new HashMap<>();

		while (N-- > 0) {
			String group = br.readLine();
			int num = Integer.parseInt(br.readLine());

			Set<String> members = new TreeSet<>();

			for (int i = 0; i < num; i++) {
				String mem = br.readLine();
				members.add(mem);
				memberToGroup.put(mem, group);
			}

			groupToMembers.put(group, members);
		}

		while (M-- > 0) {
			String name = br.readLine();
			int type = Integer.parseInt(br.readLine());

			if (type == 0) {
				// 그룹 이름이 주어지면 -> 해당 그룹 멤버들 사전순 출력
				for (String mem : groupToMembers.get(name)) {
					bw.write(mem);
					bw.newLine();
				}
			} else {
				// 멤버 이름이 주어지면 -> 해당 멤버가 속한 그룹 이름 출력
				bw.write(memberToGroup.get(name));
				bw.newLine();
			}
		}

		bw.flush();
		bw.close();
	}

}
