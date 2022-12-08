package level0;

import java.util.Arrays;

public class UniqueSort {

	public static void main(String[] args) {
		String result = Arrays.toString(solution(new int[] {10000, 20, 36, 47, 40, 6, 10, 7000}, 30));
		System.out.println(result);
	}

	static class Num implements Comparable<Num> {
        int idx;
        int val;
        int sub;
        
        Num(int idx, int val, int sub) {
            this.idx = idx;
            this.val = val;
            this.sub = sub;
        }
        
        @Override
        public int compareTo(Num o) {
            if (sub == o.sub) {
                return o.val - val;
            }
            
            return sub - o.sub;
        }
    }
    
    static int[] solution(int[] numlist, int n) {
        Num[] nums = new Num[numlist.length];
        
        for (int i = 0; i < numlist.length; i++) {
            nums[i] = new Num(i, numlist[i], Math.abs(n - numlist[i]));
        }
        
        Arrays.sort(nums);
        
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = nums[i].val;
        }
        
        return answer;
    }
}
