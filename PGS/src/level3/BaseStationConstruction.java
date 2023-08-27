package level3;

public class BaseStationConstruction {

    public static void main(String[] args) {
        int n = 11;
        int[] stations = {4, 11};
        int w = 1;
		
        int actual = solution(n, stations, w);

        int expected = 3;
        System.out.println(actual == expected);
    }
	
    static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int idx = 0;
        int pos = 1;
        
        while (pos <= n) {
            if (idx < stations.length && pos >= stations[idx] - w) {
                pos = stations[idx++] + w + 1;
                continue;
            }
            
            answer++;
            pos += (w * 2) + 1;
        }
        
        return answer;
    }
}
