import java.util.*;
import java.io.*;
public class BJ1865_웜홀 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N, M, W;
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            int[][] edges = new int[M+W][3];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u, v, w;
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                w = Integer.parseInt(st.nextToken());
                edges[i][0] = u;
                edges[i][1] = v;
                edges[i][2] = w;
            }
            for (int i = M; i < M+W; i++) {
                st = new StringTokenizer(br.readLine());
                int u, v, w;
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                w = Integer.parseInt(st.nextToken());
                edges[i][0] = u;
                edges[i][1] = v;
                edges[i][2] = -w;
            }
            long[] D = new long[N+1];
            for (int i = 2; i <= N; i++) {
                D[i] = (long)Integer.MAX_VALUE;
            }
            for (int i = 1; i < N; i++) {
                for (int j = 0; j < M+W; j++) {
                    int u = edges[j][0];
                    int v = edges[j][1];
                    int w = edges[j][2];
                    if(D[v] > D[u] + (long)w){
                        D[v] = D[u] + (long)w;
                    }
                }
            }
            boolean negativeCycle = false;
            for (int j = 0; j < M+W; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                int w = edges[j][2];
                if(D[v] > D[u] + (long)w){
                    D[v] = D[u] + (long)w;
                    negativeCycle = true;
                    break;
                }
            }
            if(negativeCycle){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
