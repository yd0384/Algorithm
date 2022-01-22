import java.io.*;
import java.util.*;
public class BJ1103_게임 {
    static int[] DY = {-1, 0, 1, 0};
    static int[] DX = {0, 1, 0, -1};
    static int[][] map;
    static int N, M;
    static boolean[][] visited;
    static int maxScore=0;
    static boolean isLoop = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if(line.charAt(j)=='H'){
                    map[i][j] = 0;
                }
                else{
                    map[i][j] = line.charAt(j) - '0';
                }
            }
        }
        visited = new boolean[N][M];
        move(0, 0, 1);
        if(isLoop){
            System.out.println(-1);
        }
        else{
            System.out.println(maxScore);
        }
    }
    static void move(int y, int x, int score){
        if(visited[y][x]){
            isLoop=true;
            return;
        }
        if(isLoop){
            return;
        }
        // 1. 현재 위치의 숫자 amount를 본다.
        int amount = map[y][x];
        visited[y][x] = true;
        // 2. 방향을 고른다.
        for(int i=0; i<4; i++){
            int my = y + DY[i]*amount;
            int mx = x + DX[i]*amount;
            //갈 수 있는가?
            //맵 안에 있고 구멍이 아닌가?
            if(my >= 0 && my < N && mx >=0 && mx < M && map[my][mx]!=0){
                // 3. 해당 방향으로 n만큼 움직인다.
                move(my, mx, score+1);
            }
        }
        //체크아웃
        visited[y][x] = false;
        maxScore = Math.max(score, maxScore);
    }
}
