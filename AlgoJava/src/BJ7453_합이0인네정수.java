import java.util.*;
import java.io.*;
public class BJ7453_합이0인네정수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }
        Integer[] AB = new Integer[n*n];
        Integer[] CD = new Integer[n*n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                AB[i*n + j] = A[i] + B[j];
                CD[i*n + j] = C[i] + D[j];
            }
        }
        Arrays.sort(AB);
        Arrays.sort(CD, Collections.reverseOrder());
        int j=0;
        int answer = 0;
        for(int i=0; i<n*n && j<n*n;){
            if(AB[i] + CD[j] == 0){
                answer++;
                i++;
                j++;
            }
            else if(AB[i] + CD[j] > 0){
                j++;
            }
            else{
                i++;
            }
        }
        System.out.println(answer);
    }
}
