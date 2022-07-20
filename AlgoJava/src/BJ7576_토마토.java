import java.io.*;
import java.util.*;

public class BJ7576_토마토 {
    static int x, y;
    static int[][] box;
    static boolean[][] visited;
    static final int[] dy = { 1, -1, 0, 0 };
    static final int[] dx = { 0, 0, 1, -1 };
    static Queue<coordinate> queue;
    static int lastDay = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        box = new int[y][x];
        queue = new LinkedList<>();
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < x; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.add(new coordinate(i, j, 0));
                }
            }
        }
        bfs();
        System.out.println(check_answer());
    }

    static void bfs() {

        while (!queue.isEmpty()) {
            coordinate current = queue.poll();
            int cy = current.y;
            int cx = current.x;
            int cday = current.day;
            for (int i = 0; i < 4; i++) {
                int my = cy + dy[i];
                int mx = cx + dx[i];
                if (my >= 0 && my < y && mx >= 0 && mx < x) {
                    if (box[my][mx] == 0) {
                        box[my][mx] = 1;
                        queue.add(new coordinate(my, mx, cday + 1));
                    }
                }
            }
            lastDay = cday;
        }
    }

    static int check_answer() {
        int tomato = 1;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                tomato *= box[i][j];
            }
        }
        if (tomato == 0) {
            return -1;
        } else {
            return lastDay;
        }
    }

    static class coordinate {
        private int y;
        private int x;
        private int day;

        public coordinate(int y, int x, int day) {
            this.y = y;
            this.x = x;
            this.day = day;
        }
    }
}
