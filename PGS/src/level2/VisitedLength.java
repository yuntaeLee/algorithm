package level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class VisitedLength {
	
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
	
	static int[] d = {1, 0, -1, 0, 1};

	public static void main(String[] args) {
		String input = "LULLLLLLU";
		int result = 7;
		
		System.out.println(result == solution(input));
	}
	
    static int solution(String dirs) {
        Map<Node, List<Node>> map = new HashMap<>();
        Node cur = new Node(0, 0);
        int answer = 0;
        
        for (int i = 0; i < dirs.length(); i++) {
            int code = convertCharToCode(dirs.charAt(i));
            Node next = new Node(cur.x + d[code], cur.y + d[code + 1]);
            
            if (outOfMap(next.x, next.y)) continue;
            
            if (!map.containsKey(next) || !map.get(next).contains(cur)) {
                map.put(next, map.getOrDefault(next, new ArrayList<>()));
                map.put(cur, map.getOrDefault(cur, new ArrayList<>()));
                map.get(next).add(cur);
                map.get(cur).add(next);
                answer++;
            }
            
            cur = next;
        }
        
        return answer;
    }
    
    private static int convertCharToCode(char c) {
        if (c == 'U') return 0;
        if (c == 'L') return 1;
        if (c == 'D') return 2;
        return 3;
    }
    
    private static boolean outOfMap(int x, int y) {
        return x < -5 || x > 5 || y < -5 || y > 5;
    }
}
