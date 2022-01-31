import java.util.*;
import java.io.*;
public class BJ2096_내려가기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] map = new int[N][3];
        int[][] maxdp = new int[N][3];
        int[][] mindp = new int[N][3];
        for(int i=0; i<N; i++){
            for(int j=0; j<3; j++){
                mindp[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<N; i++){
            if(i==0){
                for(int j=0; j<3; j++){
                    maxdp[i][j] = map[i][j];
                    mindp[i][j] = map[i][j];
                }
            }
            if(i!=N-1){
                maxdp[i+1][0] = Math.max(maxdp[i][0], maxdp[i][1]) + map[i+1][0];
                maxdp[i+1][2] = Math.max(maxdp[i][1], maxdp[i][2]) + map[i+1][2];
                maxdp[i+1][1] = Math.max(maxdp[i][0], Math.max(maxdp[i][1], maxdp[i][2])) + map[i+1][1];

                mindp[i+1][0] = Math.min(mindp[i][0], mindp[i][1]) + map[i+1][0];
                mindp[i+1][2] = Math.min(mindp[i][1], mindp[i][2]) + map[i+1][2];
                mindp[i+1][1] = Math.min(mindp[i][0], Math.min(mindp[i][1], mindp[i][2])) + map[i+1][1];
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Math.max(maxdp[N-1][0], Math.max(maxdp[N-1][1], maxdp[N-1][2])) + " " + Math.min(mindp[N-1][0], Math.min(mindp[N-1][1], mindp[N-1][2])));
        System.out.print(sb);
    }
}
