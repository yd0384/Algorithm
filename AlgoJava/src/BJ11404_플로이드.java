import java.io.*;
import java.util.*;

public class BJ11404_플로이드 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] cost = new int[N+1][N+1];
        StringTokenizer st;
        final int MAXCOST=10000001;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N;j++){
                if(i!=j){
                    cost[i][j] = MAXCOST;
                }
            }
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(cost[u][v]==0 || cost[u][v] > w){
                cost[u][v] = w;
            }
        }
        for (int m = 1; m <= N; m++) {
            for (int s = 1; s <= N; s++) {
                for (int e = 1; e <=N; e++) {
                    if(cost[s][e] > cost[s][m] + cost[m][e])
                        cost[s][e] = cost[s][m] + cost[m][e];
                }
            }
        }
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(cost[i][j]==MAXCOST){
                    sb.append("0 ");
                }
                else{
                    sb.append(cost[i][j]+" ");
                }
            }
            sb.setCharAt(sb.length()-1, '\n');
        }
        System.out.print(sb);
    }
}
