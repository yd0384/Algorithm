import java.util.*;
import java.io.*;
public class BJ11328_LCA2 {
    static int[] depth;
    static int N;
    static int[][] parent;
    static List<List<Integer>> Adj;
    static int LogN;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            Adj.add(new ArrayList<>());
        }
        for(int i=0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            Adj.get(A).add(B);
            Adj.get(B).add(A);
        }
        LogN=0;
        for(int k=1;k<N;k*=2){
            LogN++;
        }
        parent = new int[LogN+1][N+1];
        depth = new int[N+1];
        bfs(1);
        
        for(int k=1; k<=LogN; k++){
            for(int i=1; i<=N; i++){
                parent[k][i] = parent[k-1][parent[k-1][i]];
            }
        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append(LCA(A, B)+"\n");
        }
        System.out.print(sb);
    }
    //stack overflow가 발생할 수 있음, stack을 이용한 DFS나 BFS 활용해야함
    public static void bfs(int u){
        depth[u] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int v:Adj.get(now)){
                if(depth[v]==0){ // not visited
                    depth[v] = depth[now] + 1;
                    parent[0][v] = now;
                    queue.add(v);
                }
            }
        }
    }
    public static int LCA(int A, int B){
        if(depth[A] > depth[B]){
            return LCA(B, A);
        }
        int diff = depth[B] - depth[A];
        int k = 0;
        while(diff>0){
            if(diff%2==1){
                B = parent[k][B];
            }
            k++;
            diff >>= 1;
        }
        if(A == B){
            return A;
        }
        for(int i=LogN; i>=0; i--){
            if(parent[i][A] != parent[i][B]){
                A = parent[i][A];
                B = parent[i][B];
            }
        }
        return parent[0][A];
    }
}
