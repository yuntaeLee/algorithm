package level4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HotelRoomAssignment {
	static Map<Long, Long> map = new HashMap<>();

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(10, new long[] {1, 3, 4, 1, 3, 1})));
	}
	
    static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        for (int i = 0; i < room_number.length; i++) {
            answer[i] = findEmptyRoom(room_number[i]);
        }
        
        return answer;
    }
	
    static long findEmptyRoom(long room) {
        if (!map.containsKey(room)) {
            map.put(room, room + 1);
            return room;
        }
        
        long empty = findEmptyRoom(map.get(room));
        map.put(room, empty + 1);
        return empty;
    }
}