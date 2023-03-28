package level1;

public class FoodFighterCompetition {

	public static void main(String[] args) {
		int[] food = {1, 3, 4, 6};
		String result = "1223330333221";
		
		System.out.println(result.equals(solution(food)));
	}
	
	static String solution(int[] food) {
		StringBuilder answer = new StringBuilder();
		for (int i = 1; i < food.length; i++) {
			answer.append(Integer.toString(i).repeat(food[i] / 2));
		}

		return answer.toString() + "0" + answer.reverse().toString();
	}
}
