package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1991 {
	
	static StringBuilder sb = new StringBuilder();
	
	static class Node {
		char data;
		Node left;
		Node right;
		
		Node (char data) {
			this.data = data;
		}
	}
	
	static class Tree {
		Node root;
		
		public void createNode(char data, char leftData, char rightData) {
			
			// 아무것도 없는 초기 상태
			if (root == null) {
				root = new Node(data);
				
				// 좌우 값이 있는 경우에만 노드 생성
				if (leftData != '.') {
					root.left = new Node(leftData);
				}
				if (rightData != '.') {
					root.right = new Node(rightData);
				}
			}
			
			// 초기 상태가 아니라면 어디에 들어가야할지 찾기
			else {
				searchNode(root, data, leftData, rightData);
			}
		}
		
		public void searchNode(Node root, char data, char leftData, char rightData) {
			 
			// 찾을 노드가 null 이면 재귀 종료
			if (root == null) {
				return;
			}
			
			// 들어갈 위치를 찾았다면
			else if (root.data == data) {
				
				// 값이 존재할 경우에만 좌우 노드 생성
				if (leftData != '.') {
					root.left = new Node(leftData);
				}
				
				if (rightData != '.') {
					root.right = new Node(rightData);
				}
			}
			
			// 아직 찾기 못했고 탐색할 노드가 남아 있다면
			else {
				searchNode(root.left, data, leftData, rightData); // 왼쪽 재귀 탐색
				searchNode(root.right, data, leftData, rightData); // 오른쪽 재귀 탐색
			}
		}
		
		// 전위순회: 루트 -> 좌 -> 우
		void preorder(Node root) {
			sb.append(root.data); // 먼저 자신 출력
			if (root.left != null) preorder(root.left); // 그 다음 왼쪽
			if (root.right != null) preorder(root.right); // 마지막 오른쪽
		}
		
		// 중위순회: 좌 -> 루트 -> 우
		void inorder(Node root) {
			if (root.left != null) inorder(root.left); // 왼쪽 먼저
			sb.append(root.data); // 그 다음 자신 출력
			if (root.right != null) inorder(root.right); // 마지막으로 오른쪽
		}
		
		// 후위순회: 좌 -> 우 -> 루트
		void postorder(Node root) {
			if (root.left != null) postorder(root.left); // 왼쪽 먼저
			if (root.right != null) postorder(root.right); // 그 다음 오른쪽
			sb.append(root.data);
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Tree tree = new Tree();
		
		for (int i = 0; i < N; i++) {
			char[] data = br.readLine().replaceAll(" ", "").toCharArray();
			tree.createNode(data[0], data[1], data[2]);
		}
		
		// 전위 순회
		tree.preorder(tree.root);
		System.out.println(sb);
		sb.setLength(0);
		
		// 중위 순회
		tree.inorder(tree.root);
		System.out.println(sb);
		sb.setLength(0);
		
		// 후위 순회
		tree.postorder(tree.root);
		System.out.println(sb);
	}
}
