package level3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AgentUser {
	
	static int[] arr;
    static boolean[] v;
    static Set<String> unique = new HashSet<>();
    static List<List<Integer>> list = new ArrayList<>();

	public static void main(String[] args) {
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
		
		System.out.println(solution(user_id, banned_id));
	}
	
    static int solution(String[] user_id, String[] banned_id) {
        for (int i = 0; i < banned_id.length; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i = 0; i < banned_id.length; i++) {
            banned_id[i] = banned_id[i].replace('*', '.');
        }
        
        for (int i = 0; i < user_id.length; i++) {
            for (int j = 0; j < banned_id.length; j++) {
                if (user_id[i].matches(banned_id[j])) {
                    list.get(j).add(i);
                }
            }
        }
        
        v = new boolean[user_id.length];
        arr = new int[banned_id.length];
        bt(0, 0);
        
        return unique.size();
    }
	
	static void bt(int depth, int start) {
        if (depth == list.size()) {
            Set<Integer> set = new HashSet<>();
            for (int val : arr) {
                set.add(val);
            }
            
            if (set.size() == list.size()) {
                unique.add(set.toString());
            }
            
            return;
        }
        
        for (int i = start; i < list.size(); i++) {
            for (int val : list.get(i)) {
                if (!v[val]) {
                    v[val] = true;
                    arr[depth] = val;
                    bt(depth + 1, i + 1);
                    v[val] = false;
                }
            }
        }
    }
}
