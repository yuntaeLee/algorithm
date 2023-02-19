package level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FeatureDevelopment {

    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
		
        System.out.println(solution(progresses, speeds));
    }
	
    static List<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            double dday = (100 - progresses[i]) / (double) speeds[i];
            int day = (int) Math.ceil(dday);
            
            if (!q.isEmpty() && q.peek() < day) {
                list.add(q.size());
                q.clear();
            }
            
            q.offer(day);
        }
        
        list.add(q.size());
        
        return list;
    }

}
