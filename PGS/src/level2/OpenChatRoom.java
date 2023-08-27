package level2;

import java.util.HashMap;
import java.util.Map;

public class OpenChatRoom {
    
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        int changeCount = 0;
        for (String data : record) {
            String[] arr = data.split(" ");
            String action = arr[0];
            String id = arr[1];
            
            if (action.equals("Enter")) {
                map.put(id, arr[2]);
            } else if (action.equals("Change")) {
                map.put(id, arr[2]);
                changeCount++;
            }
        }
        
        String[] answer = new String[record.length - changeCount];
        int idx = 0;
        for (String data : record) {
            String[] arr = data.split(" ");
            String action = arr[0];
            String nickname = map.get(arr[1]);
            
            if (action.equals("Enter")) {
                answer[idx++] = nickname + "님이 들어왔습니다.";
            } else if (action.equals("Leave")) {
                answer[idx++] = nickname + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}
