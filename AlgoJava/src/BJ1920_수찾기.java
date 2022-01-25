import java.io.*;
import java.util.*;

public class BJ1920_수찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Set<Integer> A = new HashSet<>();
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            if(A.contains(Integer.parseInt(st.nextToken()))){
                sb.append(1+"\n");
            }
            else{
                sb.append(0+"\n");
            }
        }
        System.out.print(sb);

    }
}
