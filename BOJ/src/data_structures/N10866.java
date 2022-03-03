package data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N10866 {

	static int front = 0;
	static int back = 0;
	static int size = 0;
	static int[] deque = new int[10000];
	
	/*
	 * Deque �迭���� front�� ���������� ����Ű�� ��ġ�� �׻� ����д�.
	 * ��, ���� �տ��ִ� ���Ҵ� front + 1�� �ȴ�.
	 * 
	 * ������ ���� front�� ���� ��ġ�� ���Ҹ� �ְ� �Ǹ� ������ ��
	 * ���ܰ� �߻��Ѵ�.
	 * 
	 * ���ε��  push_front(3) �� �����Ϸ� �ϴµ� �ƹ� ���ҵ� ���� ��  
	 * front--; ���ҽ�Ų �� deque[front] = 3; �� �Ǹ�
	 * deque[9999] = 3; �� �ȴ�. �̶� front = 9999; back = 0 �� �ȴ�.
	 * 
	 * ������, ���Ұ� �� ���� ���� ��� �ش� ���Ҵ� front ���� back ���Ұ� �ȴ�.
	 * �̷��� ��츦 �����ϱ� ���� deque[front] �� ���Ҹ� ���� ��, 
	 * front = (front - 1 + array.length) % array.length; �� ���ش�.
	 * 
	 * ��������� front ��� ��ü�� deque[(front + 1) % array.length] ��ġ�� �ڸ��Ѵ�.
	 * ((front + 1) % array.length == (front + 1) % 10000)
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			
			switch(st.nextToken()) {
				
				case "push_front": {
					push_front(Integer.parseInt(st.nextToken()));
					break;
				}
				
				case "push_back" : {
					push_back(Integer.parseInt(st.nextToken()));
					break;
				}
				
				case "pop_front" : {
					sb.append(pop_front()).append('\n');
					break;
				}
				
				case "pop_back" : {
					sb.append(pop_back()).append('\n');
					break;
				}
				
				case "size" : {
					sb.append(size()).append('\n');
					break;
				}
				
				case "empty" : {
					sb.append(empty()).append('\n');
					break;
				}
				
				case "front" : {
					sb.append(front()).append('\n');
					break;
				}
				
				case "back" : {
					sb.append(back()).append('\n');
					break;
				}
			}
		}
		
		System.out.println(sb);
	}
	
	static void push_front(int val) {
		// ���Ҹ� ���� ���� �� front�� ���ҽ�Ų��.
		deque[front] = val;
		
		// ������ ���� �ʵ��� �迭 ũ�⸸ŭ �����ش�.
		front = (front - 1 + 10000) % 10000;
		
		size++;
	}
	
	static void push_back(int val) {
		/**
		 * deque[9999] ���� �� á�� ��� 0���� ����Ű�� ����
		 * �迭 ũ�⸸ŭ ���� �������� ���Ѵ�.
		 */
		back = (back + 1) % 10000;
		size++;
		deque[back] = val;
	}
	
	static int pop_front() {
		if (size == 0) return -1;
		
		/**
		 * front + 1�� front �����̹Ƿ� �ش� ���Ҹ� �ӽ� ������ �� ��
		 * front �� 1 ���� ��Ų��.
		 */
		int ret = deque[(front + 1) % 10000];
		front = (front + 1) % 10000;
		size--;
		
		return ret;
	}
	
	static int pop_back() {
		if (size == 0) return -1;
		
		int ret = deque[back];
		back = (back - 1 + 10000) % 10000;
		size--;
		
		return ret;
	}
	
	static int size() {
		return size;
	}
	
	static int empty() {
		if (size == 0) return 1;
		
		return 0;
	}
	
	static int front() {
		if (size == 0) return -1;
		
		return deque[(front + 1) % 10000];
	}
	
	static int back() {
		if (size == 0) return -1;
		
		return deque[back];
	}

}
