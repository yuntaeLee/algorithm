package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WayFindingGame {
    
    public static void main(String[] args) {
        int[][] nodeinfo = {{5,3}, {11,5}, {13,3}, {3,5}, {6,1}, {1,3}, {8,6}, {7,2}, {2,2}};

        int[][] actual = solution(nodeinfo);

        int[][] expected = {
            {7,4,6,9,1,8,5,2,3}, 
            {9,6,5,8,1,4,3,2,7}};
        
        System.out.println(Arrays.deepEquals(actual, expected));
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int value;
        Node left;
        Node right;
        
        Node(int x, int y, int value, Node left, Node right) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    
        @Override
        public int compareTo(Node o) {
            if (y == o.y) {
                return x - o.x;
            }

            return o.y - y;
        }
    }
    
    static int idx;
    static int[][] answer;
    
    static int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            list.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1, null, null));
        }
        
        Collections.sort(list);
        
        Node root = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            insertNode(root, list.get(i));
        }

        idx = 0;
        preorder(root);
        
        idx = 0;
        postorder(root);
        
        return answer;
    }
    
    static void preorder(Node root) {
        if (root != null) {
            answer[0][idx++] = root.value;
            preorder(root.left);
            preorder(root.right);
        }
    }
    
    static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            answer[1][idx++] = root.value;
        }
    }
    
    static void insertNode(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }
}
