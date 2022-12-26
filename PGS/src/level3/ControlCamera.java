package level3;

import java.util.Arrays;

public class ControlCamera {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    static int solution(int[][] routes) {
        Arrays.sort(routes, (r1, r2) -> {
            return r1[1] - r2[1];
        });
        
        int answer = 1;
        int prev = routes[0][1];
        for (int i = 1; i < routes.length; i++) {
            if (prev < routes[i][0]) {
                prev = routes[i][1];
                answer++;
            }
        }
        
        return answer;
    }

}
