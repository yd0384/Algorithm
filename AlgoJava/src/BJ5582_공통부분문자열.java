import java.io.*;
public class BJ5582_공통부분문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int N = str1.length();
        int M = str2.length();
        int[][] dp = new int[N+1][M+1];
        int max = 0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                char ch1 = str1.charAt(i-1);
                char ch2 = str2.charAt(j-1);
                if(ch1==ch2){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println(max);
    }
}