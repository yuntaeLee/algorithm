package level1;

public class MinimalRectangle {

	public static void main(String[] args) {
		int[][] input = {
				{10, 7},
				{12, 3},
				{8, 15},
				{14, 7},
				{5, 15}};
		
		int result = 120;
		
		System.out.println(result == solution(input));
	}
	
    static int solution(int[][] sizes) {
        int w = 0;
        int h = 0;
        for (int[] size : sizes) {
            w = Math.max(w, Math.max(size[0], size[1]));
            h = Math.max(h, Math.min(size[0], size[1]));
        }
        
        return w * h;
    }
}
