import java.util.*;
import java.io.*;
public class BJ1504_특정한최단경로 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, E;
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i!=j){
                    map[i][j] = -1;
                }
            }
        }        
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            map[u][v] = w;
            map[v][u] = w;
        }
        for (int k = 1; k <= N; k++) {    
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(map[i][k] != -1 && map[k][j] != -1){
                        if(map[i][j]==-1){
                            map[i][j] = map[i][k] + map[k][j];
                        }
                        else if(map[i][j] > map[i][k] + map[k][j]){
                            map[i][j] = map[i][k] + map[k][j];
                        }
                    }
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int v1, v2;
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        boolean nullpath1 = (map[1][v1] == -1) | (map[v1][v2] == -1) | (map[v2][N] == -1);
        boolean nullpath2 = (map[1][v2] == -1) | (map[v2][v1] == -1) | (map[v1][N] == -1);
        if(nullpath1 & nullpath2){
            System.out.println(-1);
        }
        else if(nullpath1){
            System.out.println(map[1][v2] + map[v2][v1] + map[v1][N]);
        }
        else if(nullpath2){
            System.out.println(map[1][v1] + map[v1][v2] + map[v2][N]);
        }
        else{
            System.out.println(Math.min(map[1][v2] + map[v2][v1] + map[v1][N], map[1][v1] + map[v1][v2] + map[v2][N]));
        }
    }
}
