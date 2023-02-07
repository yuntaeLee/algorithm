package level2;

import java.util.Arrays;

public class LifeBoat {

	public static void main(String[] args) {
		int[] people = {70, 50, 80, 50};
		int limit = 100;
		
		int result = 3;
		
		System.out.println(result == solution(people, limit));
	}
	
	static int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int l = 0;
        int r = people.length - 1;
        
        int answer = 0;
        while (l < r) {
            int sum = people[l] + people[r];
            if (sum > limit) {
                r--;
            } else {
                l++;
                r--;
            }
            
            answer++;
        }
        
        return (l == r) ? answer + 1 : answer;
    }
}
