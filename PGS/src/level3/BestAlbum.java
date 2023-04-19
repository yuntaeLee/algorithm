package level3;

public class BestAlbum {

    static class Music implements Comparable<Music> {
        int idx;
        String genre;
        int play;
        
        Music(int idx, String genre, int play) {
            this.idx = idx;
            this.genre = genre;
            this.play = play;
        }
        
        @Override
        public int compareTo(Music o) {
            if (o.play == play) {
                return idx - o.idx;
            }
            
            return o.play - play;
        }
    }
    
    public static void main(String[] args) {
        
    }

    static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> map = new HashMap<>();
        List<Music> list = new ArrayList<>();
        
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            list.add(new Music(i, genres[i], plays[i]));
        }
        
        Collections.sort(list);
        
        List<String> genreOrders = new ArrayList<>();
        for (String key : map.keySet()) {
            genreOrders.add(key);
        }
        
        Collections.sort(genreOrders, (o1, o2) -> map.get(o2) - map.get(o1));
        
        List<Music> result = new ArrayList<>();
        for (String genre : genreOrders) {
            List<Music> temp = new ArrayList<>();
            int count = 0;
            for (int i = 0; i < list.size(); i++) {
                if (genre.equals(list.get(i).genre)) {
                    temp.add(list.get(i));
                    
                    if (++count > 1) break;
                }
            }

            result.add(temp.get(0));
            if (count > 1) {
                result.add(temp.get(1));
            }
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i).idx;
        }
        
        return answer;
    }

    
}
