package level2;

import java.util.Arrays;
import java.util.TreeMap;

public class ParkingFeeCalculation {
	
    static class CarPark {
        int startTime;
        int totalTime;
        String status;
        
        public int getTotalTime() {
            return this.totalTime;
        }
        
        public String getStatus() {
            return this.status;
        }
        
        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }
        
        public void setStatus(String status) {
            this.status = status;
        }
        
        public void calUsageTime(int endTime) {
            totalTime += endTime - startTime;
        }   
    }

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        int[] result = {14600, 34400, 5000};

        System.out.println(Arrays.equals(result, solution(fees, records)));
    }
	
	static int[] solution(int[] fees, String[] records) {
        TreeMap<String, CarPark> map = new TreeMap<>();
        
        for (String s : records) {
            String[] arr = s.split(" ");
            String[] times = arr[0].split(":");
            int time = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
            
            if (arr[2].equals("IN")) {
                map.put(arr[1], map.getOrDefault(arr[1], new CarPark()));
                map.get(arr[1]).setStartTime(time);
                map.get(arr[1]).setStatus(arr[2]);
            } else {
                CarPark cp = map.get(arr[1]);
                cp.calUsageTime(time);
                cp.setStatus(arr[2]);
            }
        }
        
        int[] answer = new int[map.size()];
        int idx = 0;
        for (CarPark cp : map.values()) {
            if (cp.getStatus().equals("IN")) {
                cp.calUsageTime(23 * 60 + 59);
            }
            
            int time = cp.getTotalTime();
            time -= fees[0];
            int cost = fees[1];
            
            if (time > 0) {
                cost += (time % fees[2] == 0 ? time / fees[2] : time / fees[2] + 1) * fees[3];
            }
            
            answer[idx++] = cost;
        }
        
        return answer;
    }
}
