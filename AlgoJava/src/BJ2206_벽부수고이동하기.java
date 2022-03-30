import java.util.*;
import java.io.*;
public class BJ2206_벽부수고이동하기 {
    public static void main(String[] args) throws IOException {
        int[][] map;
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, 1, -1};
        int N, M;
        
        final int INF = 999999999;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] minDist = new int[N+1][M+1];
        int answer = INF;
        map = new int[N+1][M+1];
        List<Integer[]> walls = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            String line = br.readLine();
            for(int j = 1; j <= M; j++){
                map[i][j] = line.charAt(j-1) - '0';
                if(map[i][j] == 1) {
                    Integer[] wall = {i, j};
                    walls.add(wall);   
                }
                minDist[i][j] = INF;
            }
        }
        minDist[1][1] = 1;
        Queue<Integer[]> queue = new LinkedList<>();
        Integer[] arr = {1, 1};
        queue.add(arr);
        while(!queue.isEmpty()) {
            arr = queue.poll();
            int y = arr[0];
            int x = arr[1];
            for (int i = 0; i < 4; i++) {
                int my = y + dy[i];
                int mx = x + dx[i];
                if(my > 0 && my <= N && mx > 0 && mx <= M) {
                    if(minDist[my][mx] > minDist[y][x] + 1) {
                        if(map[my][mx] == 0) {
                            minDist[my][mx] = minDist[y][x] + 1;
                            Integer[] newArr = {my, mx};
                            queue.add(newArr);
                        }
                    }
                }
            }
        }
        answer = minDist[N][M];
        boolean[][] visited = new boolean[N+1][M+1];
        for(Integer[] wall : walls) {
            queue = new LinkedList<>();
            int y = wall[0];
            int x = wall[1];
            int before = INF;
            for(int i = 0; i< 4; i++) {
                int my = y + dy[i];
                int mx = x + dx[i];
                if(my > 0 && my <= N && mx > 0 && mx <= M) {
                    if(map[my][mx] != 1) {
                        before = Math.min(before, minDist[my][mx]);
                    }
                }
            }
            if(before==INF) {
                continue;
            }
            for(boolean[] tmp : visited) {
                Arrays.fill(tmp, false);
            }
            Integer[] arr2 = {y, x, before};
            queue.add(arr2);
            while(!queue.isEmpty()) {
                arr2 = queue.poll();
                y = arr2[0];
                x = arr2[1];
                visited[y][x] = true;
                before = arr2[2];
                if(y == N && x == M) {
                    if(before + 1 < answer) {
                        answer = before + 1;
                    }
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    int my = y + dy[i];
                    int mx = x + dx[i];
                    if(my > 0 && my <= N && mx > 0 && mx <= M) {
                        if(minDist[my][mx] > before + 1) {
                            if(map[my][mx] == 0 && !visited[my][mx]) {
                                Integer[] newArr = {my, mx, before + 1};
                                queue.add(newArr);

                            }
                        }
                    }
                }
            }
        }
        if(answer==INF){
            System.out.println(-1);
        }        
        else{
            System.out.println(answer);
        }
    }
}
