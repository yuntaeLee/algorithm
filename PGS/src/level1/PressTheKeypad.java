package level1;

public class PressTheKeypad {
	
	public String solution(int[] numbers, String hand) {
		StringBuilder sb = new StringBuilder();
        
        int postL = 10;
        int postR = 12;
        
        for (int n : numbers) {
            if (n == 1 || n == 4 || n == 7) {
                sb.append("L");
                postL = n;
            }
            else if (n == 3 || n == 6 || n == 9) {
                sb.append("R");
                postR = n;
            }
            else {
                int ll = getLength(postL, n);
                int rl = getLength(postR, n);
                
                 if (ll > rl) sb.append("R");
                 else if (rl > ll) sb.append("L");
                 else {
                     if (hand.charAt(0) == 'r') sb.append("R"); 
                     else sb.append("L");
                 }
                
                
                if (sb.charAt(sb.length() - 1) == 'R') postR = n;
                else postL = n;
            }
        }

       return sb.toString();
    }
    
    static int getLength(int post, int num) {
        post = post == 0 ? 11 : post;
        num = num == 0 ? 11 : num;
        
        int px = (post - 1) / 3;
        int py = (post - 1) % 3;
        
        return Math.abs(px - num / 3) + Math.abs(py - 1);
    }

	public static void main(String[] args) {
		
	}

}
