package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1517 {
	
	static long swapCnt = 0;
	static long[] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		long[] temp = new long[N];
		arr = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
		}
		
		mergeSort(temp, 0, N - 1);
		
		System.out.println(swapCnt);
	}
	
	static void mergeSort(long[] temp, int start, int end) {
		
		// ���� ���ۺ��� �۾����� ����
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(temp, start, mid);
			mergeSort(temp, mid + 1, end);
			
			// ����Լ��� ���ƿ��� �� mid�� �������� ���ʰ� �������� ���ĵ� ����
			// ����, ������ �� �迭�� ����
			merge(temp, start, mid, end);
		}
	}
	
	static void merge(long[] temp, int start, int mid, int end) {
		int part1 = start; // ù��° �迭�� ù��° �ε���
		int part2 = mid + 1; // �ι�° �迭�� ù��° �ε���
		int idx = start; // ���� �迭�� �ε���
		
		// ù��° �迭�� �߰����� ����, �ι�° �迭�� ������ �� ���� �ݺ�
		while (part1 <= mid && part2 <= end) {
			
			// ù��° �迭�� ���� ������ ���� �迭�� ���� �ű�� ������ ����
			if (temp[part1] <= temp[part2])
				arr[idx++] = temp[part1++];
		
			// ù��° �迭�� ���� ũ�� �ι�° �迭���� ���� �ű��, ������ ������ ����
			else {
				arr[idx++] = temp[part2++];
				swapCnt += (mid + 1 - part1);
			}
		}
		
		while (part1 <= mid) arr[idx++] = temp[part1++];
		while (part2 <= end) arr[idx++] = temp[part2++];
		
		for (int i = start; i <= end; i++) {
			temp[i] = arr[i];
		}
	}
}
