import java.io.*;
public class BJ2579_계단오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            dp[i] = nums[i];
        }
        if(N>1){
            dp[1] += dp[0];
        }
        if(N>2){
            dp[2] += Math.max(dp[0], nums[1]);
        }
        if(N>3){
            for(int i=3; i<N; i++){
                dp[i] += Math.max(dp[i-2], dp[i-3] + nums[i-1]);
            }
        }
        System.out.println(dp[N-1]);
    }
}
