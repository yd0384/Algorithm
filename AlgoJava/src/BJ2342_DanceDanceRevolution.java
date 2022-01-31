import java.util.*;
import java.io.*;
public class BJ2342_DanceDanceRevolution {
    static final int INF = Integer.MAX_VALUE;
    static int[][] cost = {
        {0, 2, 2, 2, 2},
        {INF, 1, 3, 4, 3},
        {INF, 3, 1, 3, 4},
        {INF, 4, 3, 1, 3},
        {INF, 3, 4, 3, 1}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int input;
        List<Integer> instructions = new ArrayList<>();
        instructions.add(0);
        while((input = Integer.parseInt(st.nextToken()))!= 0){
            instructions.add(input);
        }
        int N = instructions.size();
        int[][][] dp = new int [N][5][5];
        for(int i=0; i<N; i++){
            for(int j=0; j<5; j++){
                for(int k=0; k<5; k++){
                    dp[i][j][k] = INF;
                }
            }
        }
        int next;
        dp[0][0][0] = 0;
        for(int i=0; i<N-1; i++){
            for(int j=0; j<5; j++){
                for(int k=0; k<5; k++){
                    if(dp[i][j][k] != INF){
                        next = instructions.get(i+1);
                        if(k!=next){
                            dp[i+1][next][k] = Math.min(dp[i+1][next][k], dp[i][j][k] + cost[j][next]);
                        }
                        if(j!=next){
                            dp[i+1][j][next] = Math.min(dp[i+1][j][next], dp[i][j][k] + cost[k][next]);
                        }
                    }
                }
            }
        }
        int answer = INF;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                answer = Math.min(answer, dp[N-1][i][j]);
            }
        }
        System.out.println(answer);
        
    }
}
