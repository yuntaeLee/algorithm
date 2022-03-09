package level1;

import java.util.HashMap;

public class AthletesWhoDidNotFinish {
	
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String s : participant) map.put(s, map.getOrDefault(s, 0) + 1);
        for (String s : completion) map.put(s, map.get(s) - 1);
        
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
                break;
            }    
        }
        
        return answer;
    }

	public static void main(String[] args) {
		
	}

}
