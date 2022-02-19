import java.util.*;
public class BJ1629_곱셈 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long A, B, C;
        A = sc.nextLong();
        B = sc.nextLong();
        C = sc.nextLong();
        long answer = 1;
        long X = 1;
        int logX = 0;
        while(X < B){
            X <<= 1;
            logX ++;
        }
        long[] dp = new long[logX+1];
        dp[0] = A%C;
        for (int i = 1; i <= logX; i++) {
            dp[i] = (dp[i-1] * dp[i-1]) % C;
        }
        int index = 0;

        while(B>=1){
            if((B&1) == 1){
                answer = (answer * dp[index]) % C;
            }
            index++;
            B >>= 1;
        }  
        System.out.println(answer);
        sc.close();
    }
}
