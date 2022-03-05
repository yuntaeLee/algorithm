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
		
		// 끝이 시작보다 작아지면 종료
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(temp, start, mid);
			mergeSort(temp, mid + 1, end);
			
			// 재귀함수가 돌아왔을  mid를 기준으로 왼쪽과 오른쪽이 정렬된 상태
			// 따라서, 나눠진 두 배열을 병합
			merge(temp, start, mid, end);
		}
	}
	
	static void merge(long[] temp, int start, int mid, int end) {
		int part1 = start; // 첫번째 배열의 첫번째 인덱스
		int part2 = mid + 1; // 두번째 배열의 첫번째 인덱스
		int idx = start; // 최종 배열의 인덱스
		
		// 첫번째 배열이 중간까지 가고, 두번째 배열이 끝까지 갈 동안 반복
		while (part1 <= mid && part2 <= end) {
			
			// 첫번째 배열의 값이 작으면 기존 배열로 값을 옮기고 포인터 증가
			if (temp[part1] <= temp[part2])
				arr[idx++] = temp[part1++];
		
			// 첫번째 배열의 값이 크면 두번째 배열에서 값을 옮기고, 투번재 포인터 증가
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
