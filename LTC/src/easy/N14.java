package easy;

public class N14 {
    
    public static void main(String[] args) {
        String[] input = {"flower","flow","flight"};

        String output = new N14().longestCommonPrefix(input);
        
        String result = "fl";
        System.out.println(result.equals(output));
    }

    private String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }
}
