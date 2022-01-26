import java.io.*;
import java.util.*;
public class BJ11053_가장긴증가하는부분수열 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] dp = new int[N];
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }
        for(int i=N-2; i>=0; i--){
            for(int j=i+1; j<N; j++){
                if(A[i] < A[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
