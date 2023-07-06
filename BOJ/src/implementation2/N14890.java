package implementation2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N14890 {

    static int N;
    static int L;
    static int[][] map;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (pass(0, i, true)) {
                answer++;
            }

            if (pass(i, 0, false)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static boolean pass(int x, int y, boolean isHorizontal) {
        int[] heights = new int[N];
        boolean[] ramps = new boolean[N];

        for (int i = 0; i < N; i++) {
            heights[i] = isHorizontal ? map[x + i][y] : map[x][y + i];
        }

        for (int i = 0; i < N - 1; i++) {
            if (Math.abs(heights[i] - heights[i + 1]) > 1) {
                return false;
            }

            if (heights[i] == heights[i + 1]) {
                continue;
            }

            if (heights[i] - 1 == heights[i + 1]) {
                for (int j = i + 1; j <= i + L; j++) {
                    if (j >= N || ramps[j] || heights[i + 1] != heights[j]) {
                        return false;
                    }
                    ramps[j] = true;
                }
            }

            else if (heights[i] + 1 == heights[i + 1]) {
                for (int j = i; j > i - L; j--) {
                    if (j < 0 || ramps[j] || heights[i] != heights[j]) {
                        return false;
                    }
                    ramps[j] = true;
                }
            }
        }

        return true;
    }
}
