import java.io.*;
import java.util.*;

public class BJ11049_행렬곱셈순서 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] matrixSize = new int[N][2];
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            matrixSize[i][0] = r;
            matrixSize[i][1] = c;
        }
        for(int i = 1; i < N; i++){
            for(int j = 0; j < N - i; j++){
                dp[j][i+j] = Integer.MAX_VALUE;
                for(int k = j; k < i + j; k++) {
                    if(dp[j][i+j] > dp[j][k] + dp[k+1][i+j] + matrixSize[j][0] * matrixSize[k][1] * matrixSize[i+j][1]) {
                        dp[j][i+j] = dp[j][k] + dp[k+1][i+j] + matrixSize[j][0] * matrixSize[k][1] * matrixSize[i+j][1];
                    }
                }
            }
        }
        System.out.println(dp[0][N-1]);
    }
}
