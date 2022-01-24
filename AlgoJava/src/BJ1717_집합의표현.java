import java.util.*;
import java.io.*;
public class BJ1717_집합의표현 {
    static int[] parent;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        init();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int arg1 = Integer.parseInt(st.nextToken());
            int arg2 = Integer.parseInt(st.nextToken());
            if(op==0){
                union(arg1, arg2);
            }
            else if(op==1){
                sb.append((find(arg1)==find(arg2))?"YES\n":"NO\n");
            }
        }
        System.out.print(sb);
    }
    public static void init(){
        parent = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }
    public static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        parent[aRoot] = bRoot;
    }
    public static int find(int a) {
        if(parent[a]==a){
            return a;
        }
        else{
            return parent[a] = find(parent[a]);
        }
    }
}
