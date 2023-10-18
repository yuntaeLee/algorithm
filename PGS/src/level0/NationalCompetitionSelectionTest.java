package level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class NationalCompetitionSelectionTest {
    
    public static void main(String[] args) {
        int[] rank = {3, 7, 2, 5, 4, 6, 1};
        boolean[] attendance = {false, true, true, true, true, false, false};

        int actual1 = solution1(rank, attendance);
        int actual2 = solution2(rank, attendance);
        int actual3 = solution3(rank, attendance);

        int expected = 20403;
        System.out.println(actual1 == expected);
        System.out.println(actual2 == expected);
        System.out.println(actual3 == expected);
    }

    static class Rank implements Comparable<Rank> {
        int rank;
        int index;
        
        Rank(int rank, int index) {
            this.rank = rank;
            this.index = index;
        }
        
        @Override
        public int compareTo(Rank o) {
            return rank - o.rank;
        }
    }
    
    static int solution1(int[] rank, boolean[] attendance) {
        Rank[] ranks = new Rank[rank.length];
        for (int i = 0; i < rank.length; i++) {
            ranks[i] = new Rank(rank[i], i);
        }
        
        Arrays.sort(ranks);
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < attendance.length; i++) {
            if (attendance[ranks[i].index]) {
                list.add(ranks[i].index);
            }
            
            if (list.size() == 3) {
                break;
            }
        }
        
        return 10000 * list.get(0) + 100 * list.get(1) + list.get(2);
    }

    static int solution2(int[] rank, boolean[] attendance) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> rank[a] - rank[b]);
        for (int i = 0; i < attendance.length; i++) {
            if (attendance[i])
                pq.add(i);
        }

        return pq.poll() * 10000 + pq.poll() * 100 + pq.poll();
    }

    static int solution3(int[] rank, boolean[] attendance) {
        return IntStream.range(0, rank.length)
                .filter(i -> attendance[i])
                .boxed()
                .sorted(Comparator.comparing(i -> rank[i]))
                .limit(3L)
                .reduce((current, next) -> current * 100 + next)
                .get();
    }
}
