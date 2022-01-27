import java.util.*;
import java.io.*;
public class BJ2098_외판원순회 {
    static int N;
    static int[][] W, dp;
    static int Answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        W = new int [N][N];
        dp = new int[N][1 << N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0; j<1<<N;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][1] = 0;
        dfs(0, 1);
        System.out.println(Answer);
    }
    private static void dfs(int now, int visited){
        //체크인
        //목적지인가?
        //출발지로 돌아가는 길이 존재하는가는 함수가 끝나고 dp를 다시 체크하자
        if (visited == (1 << N) -1){
            if(W[now][0] == 0){
                return;
            }
            Answer = Math.min(Answer, dp[now][visited] + W[now][0]);
        }
        //연결된 곳을 순회
        for(int i=1;i<N;i++){
            int next = (1 << i);
            int nextVisited = visited | next;
            if(nextVisited == visited){
                continue;
            }
            //갈수 있는가?
            if(W[now][i] == 0){
                continue;
            } 
            if(dp[i][nextVisited] > dp[now][visited] + W[now][i]){
                dp[i][nextVisited] = dp[now][visited] + W[now][i];
                dfs(i, nextVisited);
            }
        }
        //체크아웃
    }
}
