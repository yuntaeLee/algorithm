package level3;

public class WordConversion {
	
    static int answer;

	public static void main(String[] args) {
		
	}
	
    public int solution(String begin, String target, String[] words) {
        boolean[] v = new boolean[words.length];
        dfs(begin, target, words, v, 0);
        return answer;
    }
    
    static void dfs(String begin, String target, String[] words, boolean[] v, int cnt) {
        if (begin.equals(target)) {
            answer = cnt;
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (v[i]) continue;
            
            int k = getSameAlpha(begin, words, i);
            
            if (k == begin.length() - 1) {
                v[i] = true;
                dfs(words[i], target, words, v, cnt + 1);
                v[i] = false;
            }
        }
    }
    
    static int getSameAlpha(String begin, String[] words, int idx) {
        int cnt = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) == words[idx].charAt(i)) {
                cnt++;
            }
        }
        
        return cnt;
    }
}
