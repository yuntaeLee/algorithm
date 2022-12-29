package level3;

import java.util.Arrays;

public class TravelRoute {
	
    static String[] routes;
    static boolean[] v;

	public static void main(String[] args) {

	}
	
    static String[] solution(String[][] tickets) {        
        Arrays.sort(tickets, (t1, t2) -> t1[1].compareTo(t2[1]));
        
        v = new boolean[tickets.length];
        routes = new String[tickets.length + 1];
        dfs(0, "ICN", tickets);
        
        return routes;
    }
    
    static boolean dfs(int depth, String start, String[][] tickets) {
        if (depth == tickets.length) {
            routes[depth] = start;
            return true;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!v[i] && tickets[i][0].equals(start)) {
                v[i] = true;
                routes[depth] = start;
                if (dfs(depth + 1, tickets[i][1], tickets)) return true;
                v[i] = false;
            }
        }
        
        return false;
    }
}
