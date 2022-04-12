import java.util.*;
import java.io.*;
public class BJ2206_벽부수고이동하기 {
    static final int[] dy = {1, -1, 0, 0};
    static final int[] dx = {0, 0, 1, -1};
    static int N;
    static int M;
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int minDistance = INF;
        int[][] map = new int[N+1][M+1];
        int[][][] visited = new int[N+1][M+1][2];

        for(int i = 1; i <= N; i++) {
            String line = br.readLine();
            for(int j = 1; j <= M; j++) {
                map[i][j] = line.charAt(j-1) - '0';
            }
        }
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> current = new ArrayList<>();
        current.add(1);
        current.add(1);
        current.add(1);
        visited[1][1][0] = 1;
        queue.add(current);
        while(!queue.isEmpty()) {
            current = queue.poll();
            int y = current.get(0);
            int x = current.get(1);
            int chance = current.get(2);
            if(y==N && x == M) {
                continue;
            }
            for(int i = 0; i<4; i++) {
                int my = y + dy[i];
                int mx = x + dx[i];
                if(my > 0 && mx > 0 && my <= N && mx <= M) {
                    if(chance == 1) {
                        if(map[my][mx] == 1) {
                            if(visited[my][mx][1] == 0 || visited[my][mx][1] > visited[y][x][0] + 1) {
                                List<Integer> next = new ArrayList<>();
                                next.add(my);
                                next.add(mx);
                                next.add(0);
                                queue.add(next);
                                visited[my][mx][1] = visited[y][x][0] + 1;
                            }
                        }
                        else {
                            if(visited[my][mx][0] == 0 || visited[my][mx][0] > visited[y][x][0] + 1) {
                                List<Integer> next = new ArrayList<>();
                                next.add(my);
                                next.add(mx);
                                next.add(1);
                                queue.add(next);
                                visited[my][mx][0] = visited[y][x][0] + 1;
                            }
                        }
                    }
                    else {
                        if(map[my][mx] == 0) {
                            if((visited[my][mx][1] == 0 || visited[my][mx][1] > visited[y][x][1] + 1) && (visited[my][mx][0] > visited[y][x][1] + 1 || visited[my][mx][0] == 0)) {
                                List<Integer> next = new ArrayList<>();
                                next.add(my);
                                next.add(mx);
                                next.add(0);
                                queue.add(next);
                                visited[my][mx][1] = visited[y][x][1] + 1;
                            }
                        }
                    }
                }
            }
        }
        if(minDistance > visited[N][M][0] && visited[N][M][0] != 0) {
            minDistance = visited[N][M][0];
        }
        if(minDistance > visited[N][M][1] && visited[N][M][1] != 0) {
            minDistance = visited[N][M][1];
        }
        if(minDistance == INF) {
            System.out.println(-1);
        }
        else {
            System.out.println(minDistance);
        }
    }
}
