import java.util.*;
import java.io.*;
public class BJ1208_부분수열의합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[][] cumulativeSum = new int[N][N];        int[] arr = new int [N];
        st = new StringTokenizer(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            cumulativeSum[i][i] = arr[i];
            if(arr[i] == S) {
                count++;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                cumulativeSum[i][j] = cumulativeSum[i][j-1] + arr[j];
                if(cumulativeSum[i][j] == S) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}
