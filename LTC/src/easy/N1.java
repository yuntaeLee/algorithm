package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class N1 {

	public static void main(String[] args) {
		int[] ans = twoSum(new int[] {2, 7, 11, 15} , 9);
		
		System.out.println(Arrays.toString(ans));
	}

	
	static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			
			int cal = target - nums[i];
			
			if (map.containsKey(cal)) {
				return new int[] {map.get(cal), i};
			}
			
			map.put(nums[i], i);
		}
		
		return null;
	}
}
