package level5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CountOfRooms {
	
	static class Node {
        int x;
        int y;
        
        Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);   
        }
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {5, 2, 7, 1, 6, 3}));
	}
	
	static int solution(int[] arrows) {
        int answer = 0;
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        
        Map<Node, List<Node>> map = new HashMap<>();
        Node cur = new Node(0, 0);
        
        for (int arrow : arrows) {
            for (int i = 0; i <= 1; i++) { // 스케일업
                Node next = new Node(cur.x + dx[arrow], cur.y + dy[arrow]);
                
                if (!map.containsKey(next)) {
                    map.put(next, map.getOrDefault(next, new ArrayList<>()));
                    map.put(cur, map.getOrDefault(cur, new ArrayList<>()));
                    map.get(next).add(cur);
                    map.get(cur).add(next);
                } else if (!map.get(next).contains(cur)) {
                    map.get(next).add(cur);
                    map.get(cur).add(next);
                    answer++;
                }
                
                cur = next;
            }
        }
        
        return answer;
    }
}
