package level0;

import java.util.HashSet;
import java.util.Set;

public class Parallel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    static int solution(int[][] dots) {
        Set<Double> set = new HashSet<>();
        
        for (int i = 0; i < dots.length - 1; i++) {
            for (int j = i + 1; j < dots.length; j++) {
                double lean = (double) (dots[i][1] - dots[j][1]) / (dots[i][0] - dots[j][0]);
                
                if (set.contains(lean)) return 1;
                set.add(lean);
            }
        }
        
        return 0;
    }

}
