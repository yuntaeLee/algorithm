package level2;

import java.util.LinkedList;

public class Cache {
    
    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};

        int actual = solution(cacheSize, cities);

        int expected = 21;
        System.out.println(actual == expected);
    }

    static int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        int answer = 0;
        LinkedList<String> cache = new LinkedList<>();        
        
        for (String city : cities) {
            city = city.toLowerCase();
            
            if (cache.remove(city)) {
                cache.add(city);
                answer += 1;
                continue;
            }
            
            if (cache.size() >= cacheSize) {
                cache.remove(0);
            }
            
            cache.add(city);
            answer += 5;
        }
        
        return answer;
    }
}
