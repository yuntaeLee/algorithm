package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2263 {
	
	static int N;
	static int[] in, post, pre;
	static int idx;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		in = new int[N];
		post = new int[N];
		pre = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			in[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			post[i] = Integer.parseInt(st.nextToken());
		}
		
		getPreOrder(0, N - 1, 0, N - 1);
		
		for (int n : pre) {
			sb.append(n).append(' ');
		}
		
		System.out.println(sb);
	}
	
	static void getPreOrder(int is, int ie, int ps, int pe) {
		
		if (is <= ie && ps <= pe) {
			
			pre[idx++] = post[pe];
			
			int pos = is;
			for (int i = is; i <= ie; i++) {
				if (in[i] == post[pe]) {
					pos = i;
					break;
				}
			}
			
			// 왼쪽 자식 트리를 가지고 다시 똑같은 과정 반복
			getPreOrder(is, pos - 1, ps, ps + pos - is - 1);
			
			// 오른쪽 자식 트리를 가지고 다시 똑같은 과정 반복
			getPreOrder(pos + 1, ie, ps + pos - is, pe - 1);
		}
	}
}
