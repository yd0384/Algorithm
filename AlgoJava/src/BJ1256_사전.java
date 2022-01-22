import java.util.*;

public class BJ1256_사전 {
    static int[][] pascalTriangle;
    static StringBuilder sb = new StringBuilder();
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        final int MaxValue = 1000000000;
        pascalTriangle = new int[N+M+1][N+M+1];
        pascalTriangle[0][0] = 1;
        for(int i=1;i<=N+M;i++){
            for(int j=0;j<=i;j++){
                if(j==0){
                    pascalTriangle[i][j]=1;
                }
                else{
                    pascalTriangle[i][j] = 
                    (pascalTriangle[i-1][j-1] + pascalTriangle[i-1][j]<MaxValue)? 
                    pascalTriangle[i-1][j-1] + pascalTriangle[i-1][j] : MaxValue;
                }
            }
        }
        if(pascalTriangle[N+M][N]<K){
            System.out.println(-1);
        }
        else{
            query(K, N+M, N);
            System.out.println(sb);
        }
        sc.close();
    }
    static void query(int K, int height, int remainA){
        //탈출조건먼저
        if(height==0){
            return;
        }
        //remainA가 0이면 나머지 높이만큼은 z로 확정
        if(remainA==0){
            for(;height>0;height--){
                sb.append("z");
            }
            return;
        }
        int left = pascalTriangle[height-1][remainA-1];
        if(K<=left){
            sb.append("a");
            query(K, height-1, remainA-1);
        }
        else{
            sb.append("z");
            query(K-left, height-1, remainA);
        }
    }
}
