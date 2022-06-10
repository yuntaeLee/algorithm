package union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class N1043 {
	
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int most = 0; //거짓말을 아는 사람
		
		ArrayList<Integer>[] party = new ArrayList[M];
		parents = new int[N + 1];
		
		//parents 초기화
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken()) - 1;
		
		//거짓말을 아는 사람이 없으면 모든 파티에서 거짓말 가능
		if (T == -1) {
			System.out.println(M);
			return;
		}
		
		//거짓말을 아는 사람들 union
		else {
			int parent = Integer.parseInt(st.nextToken());
			most = parent;
			
			while (T-- > 0) {
				int p = Integer.parseInt(st.nextToken());
				union(parent, p);
			}			
		}
		
		//party 초기화, 저장 + 같은 파티에 참석한 사람들 union
		for (int i = 0; i < M; i++) {
			party[i] = new ArrayList<Integer>();
			
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()) - 1;
			
			int parent = Integer.parseInt(st.nextToken());
			party[i].add(parent);
			
			while (n-- > 0) {
				int p = Integer.parseInt(st.nextToken());
				party[i].add(p);
				union(parent, p);
			}
		}
		
		//거짓말을 아는 사람이 파티에 존재 == 파티 수 감소
		int ans = M;
		for (int i = 0; i < party.length; i++) {
			for (int v : party[i]) {
				if (connected(most, v)) {
					ans--;
					break;
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static int find(int x) {
		if (parents[x] == x) return x;
		return find(parents[x]);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x < y) parents[y] = x;
		else parents[x] = y;
	}
	
	static boolean connected(int x, int y) {
		return find(x) == find(y);
	}

}
