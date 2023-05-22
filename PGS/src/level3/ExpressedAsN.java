package level3;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class ExpressedAsN {
    
    public static void main(String[] args) {
        int N = 5;
        int number = 12;

        int actual = solution(N, number);

        int expected = 4;
        System.out.println(actual == expected);
    }

    static int solution(int N, int number) {
        List<Set<Integer>> countList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            countList.add(new HashSet<>());
        }
        
        countList.get(1).add(N);
        for (int i = 2; i < 9; i++) {
            Set<Integer> countSet = countList.get(i);
            
            for (int j = 1; j <= i; j++) {
                Set<Integer> preSet = countList.get(j);
                Set<Integer> postSet = countList.get(i - j);
                
                for (int pre : preSet) {
                    for (int post : postSet) {
                        countSet.add(pre + post);
                        countSet.add(pre - post);
                        countSet.add(pre * post);
                        
                        if (post != 0) {
                            countSet.add(pre / post);
                        }
                    }
                }
            }
            
            countSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }
        
        for (Set<Integer> set : countList) {
            if (set.contains(number)) {
                return countList.indexOf(set);
            }
        }
        
        return -1;
    }
}
