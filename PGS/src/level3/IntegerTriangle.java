package level3;

public class IntegerTriangle {

	public static void main(String[] args) {

	}
	
    static int solution(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i - 1][0];
            triangle[i][i] += triangle[i - 1][i - 1];
            
            for (int j = 1; j < i; j++) {
                triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
            }
        }
        
        int answer = triangle[0][0];
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < i; j++) {
                answer = Math.max(answer, triangle[i][j]);
            }
        }
        
        return answer;
    }
}
