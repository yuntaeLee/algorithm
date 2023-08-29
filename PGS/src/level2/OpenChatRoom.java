package level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class OpenChatRoom {

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        String[] actual = solution(record);

        String[] expected = {"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."};
        System.out.println(Arrays.equals(actual, expected));
    }

    static final String ENTER = "Enter";
    static final String LEAVE = "Leave";
    static final String CHANGE = "Change";
    static final String ENTER_MESSAGE = "님이 들어왔습니다.";
    static final String LEAVE_MESSAGE = "님이 나갔습니다.";
    
    static String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        int changeCount = 0;
        for (String data : record) {
            String[] arr = data.split(" ");
            String action = arr[0];
            String id = arr[1];
            
            if (action.equals(ENTER)) {
                map.put(id, arr[2]);
            } else if (action.equals(CHANGE)) {
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
            
            if (action.equals(ENTER)) {
                answer[idx++] = nickname + ENTER_MESSAGE;
            } else if (action.equals(LEAVE)) {
                answer[idx++] = nickname + LEAVE_MESSAGE;
            }
        }
        
        return answer;
    }
}
