package level1;

public class BunchOfCards {
    
    public static void main(String[] args) {
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        String actual = solution(cards1, cards2, goal);

        String expected = "Yes";
        System.out.println(actual.equals(expected));
    }

    static String solution(String[] cards1, String[] cards2, String[] goal) {
        int c1 = 0;
        int c2 = 0;
        
        for (int i = 0; i < goal.length; i++) {
            String g = goal[i];
            
            if (c1 < cards1.length && g.equals(cards1[c1])) {
                c1++;
                continue;
            } else if (c2 < cards2.length && g.equals(cards2[c2])) {
                c2++;
                continue;
            }
            
            return "No";
        }
        
        return "Yes";
    }
}
