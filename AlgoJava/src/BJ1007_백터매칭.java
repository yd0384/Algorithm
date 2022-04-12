import java.util.*;
import java.io.*;
public class BJ1007_백터매칭 {
    static int[] vector;
    static double minVectorSize;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] points = new int[N][2];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                points[i][0] = Integer.parseInt(st.nextToken());
                points[i][1] = Integer.parseInt(st.nextToken());
            }
            
            boolean[] visited = new boolean[N];
            minVectorSize = Double.MAX_VALUE;
            combination(points, visited, 0, N, N/2);
            System.out.println(String.format("%.12f", minVectorSize));
        }
    }
    static void combination(int[][] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            use(arr, visited, n);
            return;
        }
        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r-1);
            visited[i] = false;
        }
    }
    static void use(int[][] arr, boolean[] visited, int n) {
        vector = new int[2];
        for(int i = 0; i < n; i++) {
            if(visited[i]) {
                vector[0] += arr[i][0];
                vector[1] += arr[i][1];
            }
            else {
                vector[0] -= arr[i][0];
                vector[1] -= arr[i][1];
            }
        }
        double vectorSize = Math.sqrt(Math.pow(vector[0], 2) + Math.pow(vector[1], 2));
        minVectorSize = Math.min(vectorSize, minVectorSize);
    }
}
