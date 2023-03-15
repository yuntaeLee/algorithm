package level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArbitrarilySortingStrings {

	public static void main(String[] args) {
		String[] strings = {"sun", "bed", "car"};
		String[] result = {"car", "bed", "sun"};
		
		String[] answer = solution(strings, 1);
		
		boolean isSuccess = true;
		for (int i = 0; i < result.length; i++) {
			if (!result[i].equals(answer[i])) {
				isSuccess = false;
				break;
			}
		}
		
		System.out.println(isSuccess);
	}
	
	static String[] solution(String[] strings, int n) {
		String[] answer = new String[strings.length];
		List<String> list = new ArrayList<>();
		
		for (String s : strings) {
			list.add(s.charAt(n) + s);
		}
		
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i).substring(1);
		}
		
		return answer;
	}
}
