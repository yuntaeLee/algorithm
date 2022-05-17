package medium;

public class N3 {

	public static void main(String[] args) {
		System.out.println(lengthOfLongesSubstring("adsb()a sdf12312"));
	}
	
	static int lengthOfLongesSubstring(String s) {
		if (s.length() == 0) return 0;
		
		int ans = 0;
		String str = "";
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if (str.indexOf(c) != -1) {
				str = str.substring(str.indexOf(c) + 1);
			}
			
			str += c;
			ans = Math.max(str.length(), ans);
		}
		
		return ans;
	}

}
