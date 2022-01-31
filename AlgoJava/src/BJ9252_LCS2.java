import java.io.*;
import java.util.*;
public class BJ9252_LCS2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int N = str1.length();
        int M = str2.length();
        int[][] MaxLCSLen = new int[N+1][M+1];
        // 0: 위, 1: 왼쪽, 2: 대각선
        int[][] from = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                char ch1 = str1.charAt(i-1);
                char ch2 = str2.charAt(j-1);
                if(ch1==ch2){
                    if(MaxLCSLen[i-1][j-1] + 1 > MaxLCSLen[i-1][j] && MaxLCSLen[i-1][j-1] + 1 > MaxLCSLen[i][j-1]){
                        MaxLCSLen[i][j] = MaxLCSLen[i-1][j-1] + 1;
                        from[i][j] = 2;
                    }
                    else if(MaxLCSLen[i-1][j] > MaxLCSLen[i][j-1]){
                        MaxLCSLen[i][j] = MaxLCSLen[i-1][j];
                        from[i][j] = 0;
                    }
                    else{
                        MaxLCSLen[i][j] = MaxLCSLen[i][j-1];
                        from[i][j] = 1;
                    }

                }
                else{
                    if(MaxLCSLen[i-1][j] > MaxLCSLen[i][j-1]){
                        MaxLCSLen[i][j] = MaxLCSLen[i-1][j];
                        from[i][j] = 0;
                    }
                    else{
                        MaxLCSLen[i][j] = MaxLCSLen[i][j-1];
                        from[i][j] = 1;
                    }
                }
            }
        }
        int i = N, j = M;
        Stack<Character> stack = new Stack<>();
        while(i > 0 && j > 0){
            switch(from[i][j]){
                case 0:
                    i--;
                    break;
                case 1:
                    j--;
                    break;
                case 2:
                    stack.push(str1.charAt(i-1));
                    i--;
                    j--;
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(MaxLCSLen[N][M]);
        System.out.println(sb);

    }
}
