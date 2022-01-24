import java.io.*;
import java.util.*;
public class BJ11657_타임머신 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] edges = new int[M][3];
        int[] dist = new int[N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i][0] = u;
            edges[i][1] = v;
            edges[i][2] = w;
        }
        for (int i = 2; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <N; i++) {
            for (int j = 0; j < M; j++){
                int u = edges[j][0];
                int v = edges[j][1];
                int w = edges[j][2];
                if(dist[u]==Integer.MAX_VALUE){

                }
                else{
                    if(dist[u]+w < dist[v]){
                        dist[v] = dist[u] + w;
                    }
                }
            }
        }
        boolean updated = false;
        for (int j = 0; j < M; j++){
            int u = edges[j][0];
            int v = edges[j][1];
            int w = edges[j][2];
            if(dist[u]==Integer.MAX_VALUE){

            }
            else{
                if(dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                    updated = true;
                }
            }
        }
        if(updated){
            System.out.println(-1);
        }
        else{
            StringBuilder sb = new StringBuilder();
            for(int i=2; i<=N;i++){
                if(dist[i]==Integer.MAX_VALUE){
                    sb.append("-1\n");
                }
                else{
                    sb.append(dist[i]+"\n");
                }
            }
            System.out.print(sb);
        }
    }
}
