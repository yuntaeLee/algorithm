package level1;

import java.util.ArrayList;
import java.util.List;

public class MockExam {
	
	static List<Integer> solution(int[] answers) {
	        int[] one = {1,2,3,4,5}, two = {2,1,2,3,2,4,2,5}, three = {3,3,1,1,2,2,4,4,5,5};
	        int[] cnt = new int[3];
	        
	        for (int i = 0; i < answers.length; i++) {
	            if (one[i % 5] == answers[i]) cnt[0]++;
	            if (two[i % 8] == answers[i]) cnt[1]++;
	            if (three[i % 10] == answers[i]) cnt[2]++;
	        }

	        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));

	        List<Integer> ans = new ArrayList<>();
	        
	        for (int i = 0; i < 3; i++) {
	            if (cnt[i] == max) ans.add(i + 1);
	        }
	        
	        return ans;
	}

	public static void main(String[] args) {

	}

}
