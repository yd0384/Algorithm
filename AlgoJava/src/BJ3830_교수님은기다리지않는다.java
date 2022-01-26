import java.io.*;
import java.util.*;

public class BJ3830_교수님은기다리지않는다 {
    static long[] weightDiff;
    static int[] parent;
    static int N, M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N == 0 && M == 0){
                break;
            }
            parent = new int[N+1];
            weightDiff = new long[N+1];
            for(int i=1; i<=N; i++){
                parent[i] = i;
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                char q = st.nextToken().charAt(0);
                if(q=='!'){
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    int w = Integer.parseInt(st.nextToken());
                    union(a, b, w);
                }
                else if(q=='?'){
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    if(find(a)==find(b)) {
                        sb.append(weightDiff[b] - weightDiff[a]+"\n");
                    }
                    else{
                        sb.append("UNKNOWN\n");
                    }
                }
            }
        }
        System.out.print(sb);
        
    }
    private static void union(int a, int b, int w){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot){
            return;
        }

        weightDiff[bRoot] = weightDiff[a] - weightDiff[b] + w;
        parent[bRoot] = aRoot;
    }
    private static int find(int i){
        if(parent[i]==i){
            return i;
        }
        else{
            int parentIndex = find(parent[i]);
            weightDiff[i] += weightDiff[parent[i]];
            return parent[i] = parentIndex;
        }
    }
}
