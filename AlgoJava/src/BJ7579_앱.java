import java.util.*;
import java.io.*;
public class BJ7579_앱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] mem = new int[N+1];
        int[] cost = new int[N+1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            mem[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int maxCost = 0;
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            maxCost += cost[i];
        }
        int[][] dp = new int[N+1][maxCost+1];
        for(int i=1; i<=N; i++){
            for(int j=0; j<maxCost+1; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j]);
                if(cost[i]<=j){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-cost[i]] + mem[i]);
                }
            }
        }
        int Answer = 0;
        for(int i=1; i<=maxCost; i++){
            if(dp[N][i]>=M){
                Answer = i;
                break;
            }
        }
        System.out.println(Answer);
    }
}
