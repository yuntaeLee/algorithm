package data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N11279 {
	
	static int[] heap = new int[100001];
	static int size = 0;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			int n = Integer.parseInt(br.readLine());
			
			if (n == 0) {
				if (size == 0) sb.append(0).append('\n');
				else pop();
			}
			
			else push(n);
		}
		
		System.out.println(sb);
	}
	
	static void swap(int x, int y) {
		int temp = heap[x];
		heap[x] = heap[y];
		heap[y] = temp;
	}
	
	static void push(int n) {
		heap[++size] = n;
		// 삽입한 것 부터 힙인지 확인, 힙이 아니라면 계속 부모노드로 올라가고 힙이면 break;
		for (int i = size; i > 1; i /= 2) {
			if (heap[i / 2] < heap[i]) {
				swap(i / 2, i);
			}
			else break;
		}
	}
	
	static void pop() {
		sb.append(heap[1]).append('\n');
		heap[1] = heap[size];
		heap[size--] = 0;
		
		// 삭제 후 1에서 부터 힙으로 만들어주는 과정
		for (int i = 1; i * 2 <= size;) {
			if (heap[i] > heap[i * 2] && heap[i] > heap[i * 2 + 1]) break;
			
			else if (heap[i * 2] > heap[i * 2 + 1]) {
				swap(i, i * 2);
				i = i * 2;
			}
			else {
				swap(i, i * 2 + 1);
				i = i * 2 + 1;
			}
		}
	}
}
