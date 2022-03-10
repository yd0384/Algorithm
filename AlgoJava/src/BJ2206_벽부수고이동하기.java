import java.util.*;
import java.io.*;
public class BJ2206_벽부수고이동하기 {
    static int[][] map;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int N, M;
    static boolean arrived = false;
    static boolean[][] visited;
    static int[][] minDist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1][M+1];
        minDist = new int[N+1][M+1];
        map = new int[N+1][M+1];
        for(int i = 1; i <= N; i++){
            String line = br.readLine();
            for(int j = 1; j <= M; j++){
                map[i][j] = line.charAt(j-1) - '0';
            }
        }
        DFS(1, 1, 1);
        if(minDist[N][M]==0){
            System.out.println(-1);
        }        
        else{
            System.out.println(minDist[N][M]);
        }
    }
    private static void DFS(int y, int x, int chance){
        visited[y][x] = true;
        if(y == N && x == M) {
            visited[N][M] = false;
            return;
        }
        for(int i = 0; i < 4; i++) {
            int my = dy[i] + y;
            int mx = dx[i] + x;
            if(my > 0 && mx > 0 && my <= N && mx <=M){
                if(map[my][mx] == 0 && !visited[my][mx]){
                    if(minDist[my][mx] == 0){
                        minDist[my][mx] = minDist[y][x] + 1;
                        DFS(my, mx, chance);
                    }
                    else if(minDist[my][mx] >= minDist[y][x] + 1){
                        minDist[my][mx] = minDist[y][x] + 1;
                        DFS(my, mx, chance);
                    }
                }
                else if(chance == 1 && !visited[my][mx]){
                    if(minDist[my][mx] == 0){
                        minDist[my][mx] = minDist[y][x] + 1;
                        DFS(my, mx, 0);
                    }
                    else if(minDist[my][mx] >= minDist[y][x] + 1){
                        minDist[my][mx] = minDist[y][x] + 1;
                        DFS(my, mx, 0);
                    }
                }
            }
        }
        visited[y][x] = false;
    }

}
